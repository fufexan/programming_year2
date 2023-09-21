import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicReference;

class MyRectangle {
    int width, height;

    public MyRectangle() {
        this.width = 0;
        this.height = 0;
    }

    public MyRectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    int area() {
        return width * height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

public class Exam_FufezanMihai {
    Exam_FufezanMihai () {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JTextField textField = new JTextField();
        JButton draw = new JButton("Draw");
        JButton sort = new JButton("Sort");
        Canvas canvas = new Canvas();
        AtomicReference<Graphics> g = new AtomicReference<>(canvas.getGraphics());
        JLabel label = new JLabel();
        java.util.List<MyRectangle> rects = new ArrayList<MyRectangle>();

        canvas.setBackground(Color.black);

        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.PAGE_START;
        c.fill = GridBagConstraints.BOTH;
        panel.add(textField, c);
        c.gridx = 1;
        panel.add(draw, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(label, c);
        c.gridx = 1;
        panel.add(sort, c);
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 1;
        c.weighty = 1;
        panel.add(canvas, c);

        // code goes here

        textField.addActionListener(e -> {
            try {
                String text = textField.getText();

                if (!text.matches("[0-9 ]+"))
                    throw new Exception();
                else
                    label.setText("");
            } catch (Exception e1) {
                label.setText("Please enter only integers!");
            }
        });

        draw.addActionListener(e -> {
            try {
                if (!textField.getText().matches("^[0-9]+ [0-9]+$")) {
                    throw new Exception();
                } else {
                    label.setText("");

                    StringTokenizer tokenizer = new StringTokenizer(textField.getText());
                    int width = Integer.parseInt(tokenizer.nextToken());
                    System.out.println("width " + width);
                    int height = Integer.parseInt(tokenizer.nextToken());
                    System.out.println("height " + height);

                    if (width < canvas.getWidth() && height < canvas.getHeight()) {
                        System.out.println("Rect will be drawn!");

                        g.set(canvas.getGraphics());
                        g.get().setColor(Color.WHITE);
                        System.out.println(g.get().getColor());
                        g.get().drawRect((canvas.getWidth() - width) / 2, (canvas.getHeight() - height) / 2, width, height);
//                        g.get().drawRect(0, 0, width, height);
//                        g.get().fillRect((canvas.getWidth() - width) / 2, (canvas.getHeight() - height) / 2, width, height);

                        rects.add(new MyRectangle(width, height));
                    }
                }
            } catch (Exception e1) {
                label.setText("Please enter only 2 integers!");
            }
        });

        sort.addActionListener(e -> {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("rectangles.txt");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                rects.sort(Comparator.comparingInt(MyRectangle::area));

                for (MyRectangle rect:rects) {
                    bufferedWriter.write("w " + rect.getWidth() + " h " + rect.getHeight() + " area " + rect.area() + "\n");
                }
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        JFrame frame = new JFrame("Exam");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(1280, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Exam_FufezanMihai::new);
    }
}