/*
 * 1. Implement a Java application that uses GridLayout for arranging the
 * components specific to a computing application. (TextField for I/O
 * operations, buttons for numbers, mathematical operations, screen cleaning,
 * etc.).
 */

import javax.swing.*;
import java.awt.*;

public class Lab11_Ex1_FufezanMihai {
    Lab11_Ex1_FufezanMihai() {
        GridLayout layout = new GridLayout(5, 4);
        JPanel panel = new JPanel();
        panel.setLayout(layout);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridLayout textLayout = new GridLayout();
        JPanel textPanel = new JPanel();
        textPanel.setLayout(textLayout);
        textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        layout.setHgap(5);
        layout.setVgap(5);

        Font font = new Font("Lexend", Font.PLAIN, 32);

        JTextField textField = new JTextField("0");
        textField.setFont(font);
        textPanel.add(textField);

        panel.add(new JButton("C"));
        panel.add(new JButton("%"));
        panel.add(new JButton("<"));
        panel.add(new JButton("/"));

        panel.add(new JButton("7"));
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));
        panel.add(new JButton("X"));

        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("-"));

        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("+"));

        panel.add(new JButton("00"));
        panel.add(new JButton("0"));
        panel.add(new JButton("."));
        panel.add(new JButton("="));

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
        EventQueue.invokeLater(Lab11_Ex1_FufezanMihai::new);
    }
}
