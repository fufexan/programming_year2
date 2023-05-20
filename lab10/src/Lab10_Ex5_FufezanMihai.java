/*
 * 5. Write a Frame application that draws a circle colored in all the possible
 * colors. The starting color is red and the color transitions must be made as
 * smooth as possible.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.Paint;
import java.awt.geom.Arc2D;
import java.awt.geom.Point2D;
import java.awt.Color;

public class Lab10_Ex5_FufezanMihai extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;
        float[] fractions = {0f, 0.25f, 0.5f, 0.75f, 1f};
        Color[] colors = {Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN, Color.MAGENTA};
        Point2D center = new Point2D.Float(centerX, centerY);
        float radius = Math.min(width, height) / 2f;
        ConicalGradientPaint paint = new ConicalGradientPaint(center, radius, fractions, colors);
        g2d.setPaint(paint);

        float start = 0f;
        float extent = 360f / colors.length;
        for (int i = 0; i < colors.length; i++) {
            Arc2D.Float arc = new Arc2D.Float();
            arc.setArcByCenter(centerX, centerY, radius, start, extent, Arc2D.PIE);
            start += extent;
            g2d.fill(arc);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab10_Ex5_FufezanMihai");
        frame.add(new Lab10_Ex5_FufezanMihai());
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
