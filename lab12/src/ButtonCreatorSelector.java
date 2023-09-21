import jdk.jfr.Event;

import javax.swing.*;
import java.awt.*;

public class ButtonCreatorSelector {
    ButtonCreatorSelector() {
        JFrame frame = new JFrame("Button Selector");
        JPanel panel = new JPanel();
        JMenu menu = new JMenu();

        for (int i = 5; i < 11; i++) {
            menu.add(new JMenuItem(String.valueOf(i)));
        }

        panel.add(menu);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ButtonCreatorSelector buttonCreatorSelector = new ButtonCreatorSelector();
        });
    }
}
