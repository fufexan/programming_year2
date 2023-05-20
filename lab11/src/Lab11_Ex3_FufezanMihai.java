/*
 * 3. Implement a TabbedView Java application that displays in each graphical
 * panel:
 * - a drawing area
 * - the necessary components for selecting a font type, size and color
 * - the necessary components for choosing a geometrical shape (from a
 * predefined set) and a size for the side / radius (as the case).
 */

import javax.swing.*;
import java.awt.*;

public class Lab11_Ex3_FufezanMihai {
    Lab11_Ex3_FufezanMihai() {
        JPanel canvasPanel = new JPanel();
        JPanel fontSelect = new JPanel(new GridBagLayout());
        JPanel shapeSelect = new JPanel(new GridBagLayout());
        JTabbedPane mainPane = new JTabbedPane();

        Canvas canvas = new Canvas();
        canvasPanel.setBackground(Color.white);
        canvasPanel.add(canvas);

        String[] fonts = {"Noto Sans", "Lexend", "JetBrains Mono"};
        JComboBox<String> fontBox = new JComboBox<>(fonts);
        Font font1 = new Font("Noto Sans", Font.PLAIN, 20);
        Font font2 = new Font("Lexend", Font.PLAIN, 20);
        Font font3 = new Font("JetBrains Mono Nerd Font", Font.PLAIN, 20);
        fontSelect.add(fontBox);

        String[] shapes = {"rectangle", "ellipse", "triangle", "x"};
        JComboBox<String> shapeBox = new JComboBox<>(shapes);
        JTextField radius = new JTextField("10");
        shapeSelect.add(shapeBox);
        shapeSelect.add(radius);

        mainPane.setFont(font1);
        mainPane.add("Canvas", canvasPanel);
        mainPane.add("Font", fontSelect);
        mainPane.add("Shape", shapeSelect);

        JFrame frame = new JFrame("Lab11 Ex 3 Fufezan Mihai");
        frame.add(mainPane);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Lab11_Ex3_FufezanMihai::new);
    }
}
