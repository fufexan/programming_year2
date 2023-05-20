/*
 * 4. Create an application which takes from two text fields your name and the
 * group you are part of and displays this info in a label colored in RGB
 * (122,123,129).
 */

import javax.swing.*;
import java.awt.*;

public class Lab11_Ex4_FufezanMihai {
    public Lab11_Ex4_FufezanMihai() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JTextField name = new JTextField("Your Name");
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.PAGE_START;
        c.weightx = 0.25;
        c.weighty = 0.25;
        c.insets = new Insets(10, 10, 10, 10);
        panel.add(name, c);

        JTextField group = new JTextField("Group");
        c.gridx = 1;
        panel.add(group, c);

        JLabel label = new JLabel("Your Name, group");
        label.setForeground(new Color(122,123,129));
        label.setHorizontalAlignment(JLabel.CENTER);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = GridBagConstraints.REMAINDER;
        panel.add(label, c);

        // action listeners
        name.addActionListener(e -> label.setText(name.getText() + ", " + group.getText()));
        group.addActionListener(e -> label.setText(name.getText() + ", " + group.getText()));

        // set up frame
        JFrame frame = new JFrame("Lab 11 Ex 4 Fufezan Mihai");
        frame.add(panel);
        frame.setSize(480, 320);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Lab11_Ex4_FufezanMihai::new);
    }
}
