/*
 * 3. Develop a class hierarchy of shapes and write a program that computes the
 * amount of paint needed to paint different objects. The hierarchy will
 * consist of a parent class Shape with three derived classes - Sphere,
 * Rectangle, and Cylinder. For the purposes of this exercise, the only
 * attribute a shape will have is a name and the method of interest will be one
 * that computes the area of the shape (surface area in the case of
 * three-dimensional shapes).
 *
 * Do the following:
 * A. Write an abstract class Shape with the following members:
 * - an instance variable shapeName of String type
 * - an abstract method area()
 * - a toString() method that returns the name of the shape
 * B. The file Sphere.java contains the Sphere class which is a descendant of
 * Shape. A sphere has a radius as a private integer variable and implements
 * the body of the inherited abstract method area().
 * C. Define similar classes for a rectangle and a cylinder. The classes
 * Rectangle and Cylinder are also derived from the Shape class. A rectangle is
 * defined by its length and width. A cylinder is defined by a radius and height.
 * Note: Each of the derived classes override the toString method and define
 * specific mutator and accessor methods.
 * D. The file Paint.java contains an interface that has a float constant
 * paintPerSurfaceUnit.
 * E. The file PaintThings.java implements the Paint interface and contains a
 * program that computes the amount of paint needed to paint various shapes.
 * Instantiate the three shape objects: deck <- Rectangle, bigBall <- Sphere
 * and tank <- Cylinder. Make the appropriate method calls to assign each
 * object’s specific attributes with data read from the keyboard.
 * Compute the amount of paint needed for covering each created shape.
 */

import java.util.Scanner;

public abstract class Shape {
    String shapeName = "";
    abstract double area();
    public String toString() {
        return shapeName;
    }
}

class Sphere extends Shape {
    String shapeName = "sphere";
    double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return shapeName;
    }
}

class Cylinder extends Shape {
    String shapeName = "cylinder";
    double radius, height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    double area() {
        return 2 * Math.PI * radius * height + 2 * Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return shapeName;
    }
}

class Rect extends Shape {
    String shapeName = "rectangle";
    double width, height;

    public Rect(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }

    @Override
    public String toString() {
        return shapeName;
    }
}

interface Paint {
    float paintPerSurfaceUnit = 2.4f;
}

class PaintThings implements Paint {
    public static double paintSphere(Sphere s) {
        return paintPerSurfaceUnit * s.area();
    }

    public static double paintRectangle(Rect r) {
        return paintPerSurfaceUnit * r.area();
    }

    public static double paintCylinder(Cylinder c) {
        return paintPerSurfaceUnit * c.area();
    }
}

class ShapeDriver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the radius of a sphere: ");
        Sphere bigBall = new Sphere(in.nextDouble());
        System.out.print("Enter the radius and height of a cylinder: ");
        Cylinder tank = new Cylinder(in.nextDouble(), in.nextDouble());
        System.out.print("Enter the width and height of a rectangle: ");
        Rect deck = new Rect(in.nextDouble(), in.nextDouble());

        System.out.printf("\nPaint needed for bigBall: %f\n", PaintThings.paintSphere(bigBall));
        System.out.printf("Paint needed for deck: %f\n", PaintThings.paintRectangle(deck));
        System.out.printf("Paint needed for tank: %f\n", PaintThings.paintCylinder(tank));
    }
}