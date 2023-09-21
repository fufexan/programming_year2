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

public class Lab12_Ex2_FufezanMihai {
    JTextField textField = new JTextField("0");
    String operator = "";
    double result = 0;

    Lab12_Ex2_FufezanMihai() {
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

        // Add action listeners to the buttons
        ActionListener buttonListener = new ButtonListener2(this);
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                ((JButton) component).addActionListener(buttonListener);
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Lab12_Ex2_FufezanMihai::new);
    }
}

class ButtonListener2 implements ActionListener {
    Lab12_Ex2_FufezanMihai calc;
    ButtonListener2(Lab12_Ex2_FufezanMihai calc) {
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