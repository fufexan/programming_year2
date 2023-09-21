import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

class ShapeNameInvalidException extends Exception {
}

class ShapeNumInvalidException extends Exception {
}

public class FufezanMihai_2022 {
    FufezanMihai_2022() {
        try {
            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();

            JLabel label = new JLabel();
            label.setBackground(Color.black);

            FileInputStream fileInputStream = new FileInputStream("shapes.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StreamTokenizer st = new StreamTokenizer(bufferedReader);
            st.eolIsSignificant(true);

            String name = "";
            int num = -1;

            java.util.List<String> shapes = new ArrayList<>();
            java.util.List<Integer> shapeNum = new ArrayList<>();

            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                if (st.ttype == StreamTokenizer.TT_WORD) {
                    try {
                        if (st.sval.matches("(circle|square|triangle)")) name = st.sval;
                        else throw new ShapeNameInvalidException();
                    } catch (ShapeNameInvalidException e) {
                        label.setText("Invalid shape!");
                    }
                } else if (st.ttype == StreamTokenizer.TT_NUMBER) {
                    try {
                        if (st.nval > 0) num = (int) st.nval;
                        else throw new ShapeNumInvalidException();
                    } catch (ShapeNumInvalidException e) {
                        label.setText("Invalid number!");
                    }
                }

                if (!name.isEmpty() && num != -1) {
                    shapes.add(name);
                    shapeNum.add(num);
                    name = "";
                    num = -1;
                }
            }
            bufferedReader.close();

            final int[] clickCount = {0, 0};
            Canvas canvas = new Canvas();

            canvas.addMouseListener((new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent event) {
                    Graphics g = ((Canvas) event.getSource()).getGraphics();

                    g.setColor(Color.white);
                    int x = event.getX();
                    int y = event.getY();

                    try {
                        switch (shapes.get(clickCount[1])) {
                            case "circle" -> g.drawOval(x, y, 50, 50);
                            case "square" -> g.drawRect(x, y, 50, 50);
                            case "triangle" -> {
                                Polygon p = new Polygon();
                                p.addPoint(x, y);
                                p.addPoint(x - 25, y + 40);
                                p.addPoint(x + 25, y + 40);
                                g.drawPolygon(p);
                            }
                        }

                        clickCount[0]++;
                        if (clickCount[0] == shapeNum.get(clickCount[1])) {
                            clickCount[1]++;
                            clickCount[0] = 0;
                        }
                    } catch (IndexOutOfBoundsException e) {
                        label.setText("No more shapes!");
                    }
                }
            }));

            canvas.setBackground(Color.black);

            c.anchor = GridBagConstraints.PAGE_START;
            c.fill = GridBagConstraints.HORIZONTAL;
            panel.add(label, c);

            c.gridy = 1;
            c.weighty = 1;
            c.weightx = 1;
            c.fill = GridBagConstraints.BOTH;
            panel.add(canvas, c);

            JFrame frame = new JFrame("Exam");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.add(panel);
            frame.setSize(1280, 800);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(FufezanMihai_2022::new);
    }
}
