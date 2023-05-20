/*
 * 2. Write a Frame application that will draw, inside a Canvas component, a
 * circle tangent to smaller side of the canvas.
 */

import javax.swing.*;
import java.awt.*;

class ExtendedCanvas extends Canvas {
    Graphics g;
    int radius;

    ExtendedCanvas(int width, int height) {
        this.radius = Math.min(width, height);
        this.setSize(new Dimension(width, height));
        this.setBackground(new Color(220, 224, 232));
    }


    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(254, 100, 11));
        g.drawOval(0, 0, radius, radius);
        g.fillOval(0, 0, radius, radius);
    }
}
public class Lab10_Ex2_FufezanMihai {
    public int width = 1280, height = 800;
    JFrame frame = new JFrame("Lab10_Ex2_FufezanMihai");
    Canvas canvas = new ExtendedCanvas(width, height);

    Lab10_Ex2_FufezanMihai() {
        frame.add(canvas);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Lab10_Ex2_FufezanMihai window = new Lab10_Ex2_FufezanMihai();
            }
        });
    }
}
