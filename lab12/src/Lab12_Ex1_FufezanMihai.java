/*
 * 1. Implement a Java application that uses GridLayout for arranging the
 * components specific to a computing application. (TextField for I/O
 * operations, buttons for numbers, mathematical operations, screen cleaning,
 * etc.).
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab12_Ex1_FufezanMihai {
    JTextField textField = new JTextField("0");
    double result = 0;
    String operator = "";

    Lab12_Ex1_FufezanMihai() {
        GridLayout layout = new GridLayout(5, 4);
        JPanel panel = new JPanel();
        panel.setLayout(layout);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel textPanel = new JPanel(new GridLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        layout.setHgap(5);
        layout.setVgap(5);

        Font font = new Font("Lexend", Font.PLAIN, 32);

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

        // Add action listeners to the buttons
        ActionListener buttonListener = new ButtonListener1(this);
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                ((JButton) component).addActionListener(buttonListener);
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Lab12_Ex1_FufezanMihai::new);
    }
}

class ButtonListener1 implements ActionListener {
    Lab12_Ex1_FufezanMihai calc;
    ButtonListener1(Lab12_Ex1_FufezanMihai calc) {
        this.calc = calc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonText = button.getText();

        switch (buttonText) {
            case "C" -> clearScreen();
            case "=" -> calculateResult();
            case "<" -> deleteLastDigit();
            case "+", "-", "X", "/", "%" -> handleOperator(buttonText);
            default -> appendToScreen(buttonText);
        }
    }

    private void clearScreen() {
        calc.textField.setText("0");
        calc.result = 0;
        calc.operator = "";
    }

    private void calculateResult() {
        double currentNumber = Double.parseDouble(calc.textField.getText());

        switch (calc.operator) {
            case "+" -> calc.result += currentNumber;
            case "-" -> calc.result -= currentNumber;
            case "X" -> calc.result *= currentNumber;
            case "/" -> calc.result /= currentNumber;
            case "%" -> calc.result %= currentNumber;
            default -> calc.result = currentNumber;
        }

        calc.textField.setText(Double.toString(calc.result));
    }
    private void deleteLastDigit() {
        String text = calc.textField.getText();
        if (text.length() > 1) {
            text = text.substring(0, text.length() - 1);
        } else {
            text = "0";
        }
        calc.textField.setText(text);
    }

    private void handleOperator(String operator) {
        calc.operator = operator;
        calc.result = Double.parseDouble(calc.textField.getText());
        calc.textField.setText("0");
    }

    private void appendToScreen(String text) {
        if (calc.textField.getText().equals("0")) {
            calc.textField.setText(text);
        } else {
            calc.textField.setText(calc.textField.getText() + text);
        }
    }
}
