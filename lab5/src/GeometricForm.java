/*
 * 2. Define an interface called GeometricForm that contains methods which
 * return the area and perimeter of the geometric form. Implement the interface
 * for: squares, rectangles, circles, equilateral triangles and isosceles
 * triangles. Read from the keyboard N distinct geometric forms specified by
 * their type and specific parameters (for example for a circle, you would need
 * to read its radius). Compute the total area and perimeter of all the
 * geometric forms, taking into account the fact that they do not overlap.
 */

import java.util.ArrayList;
import java.util.Scanner;

public interface GeometricForm {
    double perimeter();
    double area();
}

class Circle implements GeometricForm {
    double radius;

    public Circle() {
        this.radius = 1;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements GeometricForm {
    double length, height;

    public Rectangle() {
        this.length = 2;
        this.height = 1;
    }

    public Rectangle(double length, double height) {
        this.length = length;
        this.height = height;
    }

    @Override
    public double perimeter() {
        return length * 2 + height * 2;
    }

    @Override
    public double area() {
        return length * height;
    }
}

class Square implements GeometricForm {
    double length;

    public Square() {
        this.length = 1;
    }

    public Square(double length) {
        this.length = length;
    }

    @Override
    public double perimeter() {
        return length * 4;
    }

    @Override
    public double area() {
        return length * length;
    }
}

class EquilateralTriangle extends Square {
    public EquilateralTriangle(double side) {
        this.length = side;
    }

    @Override
    public double perimeter() {
        return length * 3;
    }

    @Override
    public double area() {
        return length * length * Math.sqrt(3) / 4;
    }
}

class IsoscelesTriangle extends Rectangle {
    public IsoscelesTriangle(double base, double height) {
        this.length = base;
        this.height = height;
    }

    double hypotenuse(double b, double h) {
        return (b/2) * (b/2) + h * h;
    }
    @Override
    public double perimeter() {
        return length + 2 * hypotenuse(length, height);
    }

    @Override
    public double area() {
        return length * height / 2;
    }
}

class GeometricFormDriver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of geometric forms you want to add: ");
        int n = in.nextInt();

        ArrayList<Circle> circles = new ArrayList<Circle>();
        ArrayList<Square> squares = new ArrayList<Square>();
        ArrayList<IsoscelesTriangle> itriangles = new ArrayList<IsoscelesTriangle>();
        ArrayList<EquilateralTriangle> etriangles = new ArrayList<EquilateralTriangle>();
        ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();

        for (int i = 0; i < n; i++) {
            System.out.printf("Geometric form #%d\nType: ", i);
            String type = in.next().toLowerCase();

            switch (type) {
                case "circle" -> {
                    System.out.print("Radius: ");
                    circles.add(new Circle(in.nextDouble()));
                }
                case "square" -> {
                    System.out.print("Length: ");
                    squares.add(new Square(in.nextDouble()));
                }
                case "rectangle" -> {
                    System.out.print("Length and height: ");
                    rectangles.add(new Rectangle(in.nextDouble(), in.nextDouble()));
                }
                case "isosceles" -> {
                    System.out.print("Base and height: ");
                    itriangles.add(new IsoscelesTriangle(in.nextDouble(), in.nextDouble()));
                }
                case "equilateral" -> {
                    System.out.print("Side: ");
                    etriangles.add(new EquilateralTriangle(in.nextDouble()));
                }
            }
        }

        System.out.printf("\nTotal perimeter size: %f\n", perimeter(circles, squares, rectangles, etriangles, itriangles));
        System.out.printf("Total area size: %f\n", area(circles, squares, rectangles, etriangles, itriangles));
    }

    public static double perimeter(ArrayList<Circle> circles, ArrayList<Square> squares,
                                   ArrayList<Rectangle> rectangles, ArrayList<EquilateralTriangle> etriangles,
                                   ArrayList<IsoscelesTriangle> itriangles) {
        double p = 0;
        for (Circle c : circles)
            p += c.perimeter();
        for (Square s : squares)
            p += s.perimeter();
        for (Rectangle r : rectangles)
            p += r.perimeter();
        for (EquilateralTriangle e : etriangles)
            p += e.perimeter();
        for (IsoscelesTriangle i : itriangles)
            p += i.perimeter();

        return p;
    }
    
    public static double area(ArrayList<Circle> circles, ArrayList<Square> squares,
                              ArrayList<Rectangle> rectangles, ArrayList<EquilateralTriangle> etriangles,
                              ArrayList<IsoscelesTriangle> itriangles) {
        double a = 0;
        for (Circle c : circles)
            a += c.area();
        for (Square s : squares)
            a += s.area();
        for (Rectangle r : rectangles)
            a += r.area();
        for (EquilateralTriangle e : etriangles)
            a += e.area();
        for (IsoscelesTriangle i : itriangles)
            a += i.area();

        return a;
    }
}
