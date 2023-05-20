import javax.swing.*;
import java.awt.*;

public class TVTestCard {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TV Test Card");
        JPanel panel = new JPanel(new GridLayout(4, 5, 10, 10));

        int[] grayValues = { 16, 32, 48, 64, 80, 96, 112, 128, 144, 160 };
        for (int i = 0; i < grayValues.length; i++) {
            JPanel grayPanel = new JPanel();
            grayPanel.setBackground(new Color(grayValues[i], grayValues[i], grayValues[i]));
            panel.add(grayPanel);
        }

        panel.add(new ColorPanel(Color.RED));
        panel.add(new ColorPanel(Color.GREEN));
        panel.add(new ColorPanel(Color.BLUE));
        panel.add(new ColorPanel(Color.YELLOW));
        panel.add(new ColorPanel(Color.CYAN));
        panel.add(new ColorPanel(Color.MAGENTA));

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static class ColorPanel extends JPanel {
        private final Color color;

        public ColorPanel(Color color) {
            this.color = color;
            setPreferredSize(new Dimension(50, 50));
            setBackground(color);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (color.equals(Color.YELLOW) || color.equals(Color.WHITE)) {
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.WHITE);
            }
            g.setFont(new Font("Arial", Font.BOLD, 16));
            g.drawString(color.toString(), 5, getHeight() - 5);
        }
    }
}