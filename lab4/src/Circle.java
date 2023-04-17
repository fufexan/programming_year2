/*
 * 10. Implement a class named Circle with the private attributes color (int),
 * radius (float), planar position (2 integer). Define the specific
 * constructors and setter getter methods. The color is divided in 4 bytes,
 * each of them representing the transparency and the quantities of R, G and B.
 * In the main method (included in another class), read from the keyboard the
 * data for n Circle objects. Implement the methods that receive as parameter
 * the array of objects and display:
 * - the circles whose center is included in one of the 4 quadrants
 * - the circles that are included entirely in one of the 4 quadrants
 * - the circles that have the centers on the same horizontal or vertical line
 * - the circles that have the R, G or B quantities in a certain specified interval
 */

import java.util.Scanner;

public class Circle {
    private int color, planarX, planarY;
    private float radius;

    public Circle() {
        this.color = 0;
        this.planarX = 0;
        this.planarY = 0;
        this.radius = 0f;
    }

    public Circle(int color, int planarX, int planarY, float radius) {
        this.color = color;
        this.planarX = planarX;
        this.planarY = planarY;
        this.radius = radius;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getPlanarX() {
        return planarX;
    }

    public void setPlanarX(int planarX) {
        this.planarX = planarX;
    }

    public int getPlanarY() {
        return planarY;
    }

    public void setPlanarY(int planarY) {
        this.planarY = planarY;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}

class CircleDriver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of circles you want to input: ");
        int num = in.nextInt();
        if (num < 1) {
            System.err.println("Not enough circles!");
            System.exit(1);
        }
        Circle[] circles = new Circle[num];

        readCircles(circles);

        System.out.println("\nCircles which have their center inside quadrants:\n");
        checkQuadrant(circles, 1);
    }

    private static void checkQuadrant(Circle[] circles, int q) {
        int x0, y0, x1, y1;
        switch (q) {
            case 1 -> {
                x0 = 1;
                y0 = 0;
                x1 = 0;
                y1 = 1;
            }
            case 2 -> {
                x0 = 0;
                y0 = 1;
                x1 = -1;
                y1 = 0;
            }
            case 3 -> {
                x0 = -1;
                y0 = 0;
                x1 = 0;
                y1 = -1;
            }
            case 4 -> {
                x0 = 0;
                y0 = -1;
                x1 = 1;
                y1 = 0;
            }
            case 5 -> {
                x0 = 1;
                y0 = 1;
                x1 = -1;
                y1 = -1;
            }
        }

        for (int i = 0; i < circles.length; i++) {
            if(circles[i].getPlanarX() > x0 )
        }
    }

    public static void readCircles(Circle[] circles) {
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < circles.length; i++) {
            System.out.printf("\nCircle #%d\n\n", i);

            System.out.print("Color amount in red (max 255): ");
            int red = in.nextInt();
            System.out.print("Color amount in green (max 255): ");
            int green = in.nextInt();
            System.out.print("Color amount in blue (max 255): ");
            int blue = in.nextInt();
            System.out.print("Opacity amount (max 255): ");
            int opacity = in.nextInt();
            int color = (red << 24) & (green << 16) & (blue << 8) & opacity;

            System.out.print("Planar position (x y): ");
            int x = in.nextInt();
            int y = in.nextInt();

            System.out.print("Radius: ");
            float r = in.nextFloat();

            circles[i] = new Circle(color, x, y, r);
        }
    }
}
