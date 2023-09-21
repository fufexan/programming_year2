/*
 * 2. Write a Java application which includes 3 sliders which enables the user
 * to set the color of a 100x100 square. The square will be drawn using a
 * specific component (Canvas, etc.).
 */

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Lab12_Ex2REAL_FufezanMihai {
    Lab12_Ex2REAL_FufezanMihai() {
        JFrame frame = new JFrame("Colored Box");
        JPanel panel = new JPanel(new GridLayout(1, 2));
        JPanel sliderBox = new JPanel(new GridLayout(3, 2));
        JPanel box = new JPanel();
        JSlider r = new JSlider();
        JSlider g = new JSlider();
        JSlider b = new JSlider();
        JTextField rt = new JTextField("10");
        JTextField gt = new JTextField("10");
        JTextField bt = new JTextField("10");
        AtomicInteger red = new AtomicInteger(10);
        AtomicInteger green = new AtomicInteger(10);
        AtomicInteger blue = new AtomicInteger(10);

        sliderBox.add(r);
        sliderBox.add(rt);
        sliderBox.add(g);
        sliderBox.add(gt);
        sliderBox.add(b);
        sliderBox.add(bt);

        r.setMaximum(255);
        g.setMaximum(255);
        b.setMaximum(255);

        r.setMinimum(0);
        g.setMinimum(0);
        b.setMinimum(0);

        r.setValue(10);
        g.setValue(10);
        b.setValue(10);

        box.setBackground(new Color(10, 10, 10));

        r.addChangeListener(e -> {
            red.set(r.getValue());
            box.setBackground(new Color(red.get(), green.get(), blue.get()));
            rt.setText(String.valueOf(red.get()));
        });
        g.addChangeListener(e -> {
            green.set(g.getValue());
            box.setBackground(new Color(red.get(), green.get(), blue.get()));
            gt.setText(String.valueOf(green.get()));
        });
        b.addChangeListener(e -> {
            blue.set(b.getValue());
            box.setBackground(new Color(red.get(), green.get(), blue.get()));
            bt.setText(String.valueOf(blue.get()));
        });
        rt.addActionListener(e -> {
            red.set(Integer.parseInt(rt.getText()));
            box.setBackground(new Color(red.get(), green.get(), blue.get()));
            r.setValue(Integer.parseInt(rt.getText()));
        });
        gt.addActionListener(e -> {
            green.set(Integer.parseInt(gt.getText()));
            box.setBackground(new Color(red.get(), green.get(), blue.get()));
            g.setValue(Integer.parseInt(gt.getText()));
        });
        bt.addActionListener(e -> {
            blue.set(Integer.parseInt(bt.getText()));
            box.setBackground(new Color(red.get(), green.get(), blue.get()));
            b.setValue(Integer.parseInt(bt.getText()));
        });

        panel.add(sliderBox);
        panel.add(box);

        frame.add(panel);
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Lab12_Ex2REAL_FufezanMihai::new);
    }
}
