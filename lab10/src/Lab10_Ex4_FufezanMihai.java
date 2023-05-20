 /*
 * 4. Write a Frame application that displays a TV test card. The card will
 * contain at least 10 levels of grey and the basic colors red, green, blue,
 * yellow, cyan and magenta. The card will cover the entire surface of the
 * component that displays it (Canvas, etc.).
 */

import javax.swing.*;
import java.awt.*;

public class Lab10_Ex4_FufezanMihai {
    JFrame frame = new JFrame("Lab10_Ex4_FufezanMihai");
    JPanel mainPanel = new JPanel(new GridLayout(2, 8));

    Lab10_Ex4_FufezanMihai() {
        JPanel[] panels = new JPanel[16];
        for (int i = 0; i < 16; i++) {
            panels[i] = new JPanel();
        }

        panels[0].setBackground(new Color(25, 25, 25));
        panels[1].setBackground(new Color(50, 50, 50));
        panels[2].setBackground(new Color(75, 75, 75));
        panels[3].setBackground(new Color(100, 100, 100));
        panels[4].setBackground(new Color(125, 125, 125));
        panels[5].setBackground(new Color(150, 150, 150));
        panels[6].setBackground(new Color(175, 175, 175));
        panels[7].setBackground(new Color(200, 200, 200));
        panels[8].setBackground(new Color(225, 225, 225));
        panels[9].setBackground(new Color(250, 250, 250));
        panels[10].setBackground(new Color(255, 0, 0));
        panels[11].setBackground(new Color(0, 255, 0));
        panels[12].setBackground(new Color(0, 0, 255));
        panels[13].setBackground(new Color(0, 255, 255));
        panels[14].setBackground(new Color(255, 0, 255));
        panels[15].setBackground(new Color(255, 255, 0));

        for(JPanel panel : panels) {
            mainPanel.add(panel);
        }

        frame.add(mainPanel);
        frame.setSize(800,200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Lab10_Ex4_FufezanMihai window = new Lab10_Ex4_FufezanMihai();
            }
        });
    }
}
