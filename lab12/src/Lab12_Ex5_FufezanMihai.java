/*
 * 5. Write a Java GUI application which includes a course registration form.
 * The interface contains 2 TextField components for entering the name and the
 * group and a ComboBox selection list for choosing the course name. The form
 * has a ”Register” button that saves in a file the data entered by the user.
 * Monitor the keyboard events for allowing only letters in the first TextField
 * and only digits in the second one.
 */

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.Instant;
import java.util.Date;

public class Lab12_Ex5_FufezanMihai {
    public Lab12_Ex5_FufezanMihai() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/" + Date.from(Instant.now()));
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            JFrame frame = new JFrame("Registration");
            GridLayout gridlayout = new GridLayout(2, 2);
            JPanel panel = new JPanel(gridlayout);

            JTextField name = new JTextField("Name");
            JTextField group = new JTextField("Group");
            JComboBox<String> selector = new JComboBox<>();
            JButton button = new JButton("Register");

            gridlayout.setVgap(5);
            gridlayout.setHgap(5);

            panel.add(name);
            panel.add(selector);
            panel.add(group);
            panel.add(button);

            frame.add(panel);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            selector.addItem("Java");
            selector.addItem("C");
            selector.addItem("C++");
            selector.addItem("Python");
            selector.addItem("Rust");
            selector.addItem("Haskell");

            name.addActionListener(e -> {
                try {
                    String uFName = name.getText();

                    if (!uFName.matches("[A-Za-z ]+"))
                        throw new Exception();
                } catch (Exception e1) {
                    name.setText("");
                    JOptionPane.showMessageDialog(name, "Please enter a valid name!");
                }
            });

            group.addActionListener(e -> {
                try {
                    String uFName = group.getText();

                    if (!uFName.matches("[0-9]+"))
                        throw new Exception();
                } catch (Exception e1) {
                    group.setText("");
                    JOptionPane.showMessageDialog(group, "Please enter a valid group number!");
                }
            });


            button.addActionListener(e -> {
                try {
                    bufferedWriter.write("Name: " + name.getText() + ", group " + group.getText() + ", course " + selector.getSelectedItem() + "\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Lab12_Ex5_FufezanMihai::new);
    }
}
