/*
 * 1. Write a Frame application that will display in a panel your name and
 * group. The text will be blue and centered both on the horizontal and
 * vertical, given the dimension of the panel.
 */

import javax.swing.*;
import java.awt.*;

public class CenteredJLabel {
    private JFrame frame = new JFrame("Ex1");
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel("Fufezan Mihai, group 2022");

    public CenteredJLabel() {
        panel.setLayout(new GridBagLayout());
        panel.add(label);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CenteredJLabel centeredJLabel = new CenteredJLabel();
            }
        });
    }
}
