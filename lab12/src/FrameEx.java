import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student {
    String name;
    int group;

    public Student(String n, int g) {
        name = n;
        group = g;
    }

    public String getName() {
        return name;
    }

    public void setName(String s) {
        name = s;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int g) {
        group = g;
    }

    public String toString() {
        return "Name: " + name + " Group: " + group;
    }
}// student class

public class FrameEx extends JFrame {
    JTextField tfN, tfG;
    JButton bCopy, bSave;
    JTextArea ta;
    JPanel p1, p2;
    List<Student> list;

    public FrameEx(String title) {
        super(title);
        setSize(600, 600);
        setLocation(100, 100);
        setLayout(new FlowLayout());
        init();
    }

    public void init() {
        list = new ArrayList<>();
        tfN = new JTextField(10);
        tfG = new JTextField(10);
        ta = new JTextArea(10, 10);

        bCopy = new JButton("Copy");
        bSave = new JButton("Save");

        tfN.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!Character.isLetter(c) && (c != KeyEvent.VK_BACK_SPACE))
                    ke.consume();
            }
        });

        tfG.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!Character.isDigit(c) && (c != KeyEvent.VK_BACK_SPACE))
                    ke.consume();
            }
        });

        p1 = new JPanel();
        p1.setPreferredSize(new Dimension(300, 300));
        p1.setBorder(BorderFactory.createEtchedBorder());
        p1.add(tfN);
        p1.add(tfG);
        p1.add(ta);

        add(p1);

        bCopy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                ta.append(tfN.getText() + " " + tfG.getText() + "\n");
                Student s = new Student(tfN.getText(), Integer.parseInt(tfG.getText()));
                list.add(s);
            }
        });


        bSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                list.sort(Comparator.comparing(Student::getName));
                try {
                    PrintWriter fw = new PrintWriter(new FileWriter("test.txt"), true);
                    for (Student s : list) {
                        fw.write(s.toString());
                    }
                    fw.close();
                } catch (IOException ie) {
                    ie.printStackTrace();
                }
            }
        });

        p2 = new JPanel();
        p2.setPreferredSize(new Dimension(200, 100));
        p2.setBorder(BorderFactory.createLineBorder(Color.RED));
        p2.add(bCopy);
        p2.add(bSave);
        add(p2);
    }


}// FrameEx class


class Main {
    public static void main(String[] args) {
        FrameEx f = new FrameEx("Example");
        f.setVisible(true);
    }
} // Main class
