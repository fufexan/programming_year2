/*
 * 3. Write a Frame application that displays an image stored in a local file.
 * Below the image display the filename with a predefined Font. The text is
 * drawn using a color composed of 3 predefined components (red, green, blue).
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;


public class Lab10_Ex3_FufezanMihai {
    JFrame frame = new JFrame("Lab10_Ex3_FufezanMihai");
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    Font font = new Font("Lexend", Font.BOLD, 16);
    String filename = "src/atomstr.png";
    ImageIcon image = new ImageIcon(filename);

    int width = 800, height = 500;

    Lab10_Ex3_FufezanMihai() {
        label.setFont(font);
        label.setText(filename);
        label.setForeground(new Color(136, 57, 239));
        panel.add(label);

        frame.add(new JLabel(image), BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Lab10_Ex3_FufezanMihai window = new Lab10_Ex3_FufezanMihai();
            }
        });
    }
}
