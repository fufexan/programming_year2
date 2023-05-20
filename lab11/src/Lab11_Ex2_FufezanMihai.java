/*
 * 1. Implement a Java application that uses GridLayout for arranging the
 * components specific to a computing application. (TextField for I/O
 * operations, buttons for numbers, mathematical operations, screen cleaning,
 * etc.).
 */

import javax.swing.*;
import java.awt.*;

public class Lab11_Ex2_FufezanMihai {
    Lab11_Ex2_FufezanMihai() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridBagLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints textFieldConstraints = new GridBagConstraints();
        textFieldConstraints.gridx = 0;
        textFieldConstraints.gridy = 0;
        textFieldConstraints.gridwidth = 4;
        textFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
        textFieldConstraints.anchor = GridBagConstraints.PAGE_START;
        textFieldConstraints.weightx = 1.0;

        Font font = new Font("Lexend", Font.PLAIN, 32);

        JTextField textField = new JTextField("0");
        textField.setFont(font);
        textPanel.add(textField, textFieldConstraints);

        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 0;
        buttonConstraints.fill = GridBagConstraints.BOTH;
        buttonConstraints.anchor = GridBagConstraints.PAGE_START;
        buttonConstraints.weightx = 0.25;
        buttonConstraints.weighty = 0.25;
        buttonConstraints.insets = new Insets(5, 5, 5, 5);
        panel.add(new JButton("C"), buttonConstraints);

        buttonConstraints.gridx = 1;
        panel.add(new JButton("%"), buttonConstraints);
        buttonConstraints.gridx = 2;
        panel.add(new JButton("<"), buttonConstraints);
        buttonConstraints.gridx = 3;
        panel.add(new JButton("/"), buttonConstraints);

        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 1;
        panel.add(new JButton("7"), buttonConstraints);
        buttonConstraints.gridx = 1;
        panel.add(new JButton("8"), buttonConstraints);
        buttonConstraints.gridx = 2;
        panel.add(new JButton("9"), buttonConstraints);
        buttonConstraints.gridx = 3;
        panel.add(new JButton("X"), buttonConstraints);

        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 2;
        panel.add(new JButton("4"), buttonConstraints);
        buttonConstraints.gridx = 1;
        panel.add(new JButton("5"), buttonConstraints);
        buttonConstraints.gridx = 2;
        panel.add(new JButton("6"), buttonConstraints);
        buttonConstraints.gridx = 3;
        panel.add(new JButton("-"), buttonConstraints);

        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 3;
        panel.add(new JButton("1"), buttonConstraints);
        buttonConstraints.gridx = 1;
        panel.add(new JButton("2"), buttonConstraints);
        buttonConstraints.gridx = 2;
        panel.add(new JButton("3"), buttonConstraints);
        buttonConstraints.gridx = 3;
        panel.add(new JButton("+"), buttonConstraints);

        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 4;
        panel.add(new JButton("00"), buttonConstraints);
        buttonConstraints.gridx = 1;
        panel.add(new JButton("0"), buttonConstraints);
        buttonConstraints.gridx = 2;
        panel.add(new JButton("."), buttonConstraints);
        buttonConstraints.gridx = 3;
        panel.add(new JButton("="), buttonConstraints);

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(textPanel, BorderLayout.NORTH);
        frame.add(new JSeparator(), BorderLayout.CENTER);
        frame.add(panel);
        frame.setSize(600, 800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Lab11_Ex2_FufezanMihai::new);
    }
}
