/*
 * Lab 6, Fufezan Mihai, ex 5
 * 5. Write an application which checks if 3 random points form an obtuse
 * triangle. If the condition is not met, a specific exception is thrown:
 * AcuteTriangle, RightTriangle. If the 3 points are on the same line or if the
 * segments determined by the 3 points cannot make up a triangle, throw an
 * ImpossibleTriangle exception, and within the corresponding catch block print
 * a warning and throw a RuntimeException.
 */

import java.util.Arrays;
import java.util.Scanner;

class Point {
    public int a, b;
}

class AcuteTriangle extends Exception {
    AcuteTriangle() {
        System.out.println("The points form an acute triangle!");
    }
}

class RightTriangle extends Exception {
    RightTriangle() {
        System.out.println("The points form a right triangle!");
    }
}

class ImpossibleTriangle extends Exception {
    ImpossibleTriangle() {
        System.out.println("The points cannot form a triangle!");
    }
}

public class TriangleCheck {
    public static void main(String[] args) throws AcuteTriangle, ImpossibleTriangle, RightTriangle {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 3 points (`x y`, newline after each):");

        Point[] points = new Point[3];
        int[] sides = new int[3];
        for (int i = 0; i < 3; i++) {
            points[i] = new Point();
            points[i].a = in.nextInt();
            points[i].b = in.nextInt();
        }

        for (int i = 0; i < sides.length; i++) {
            Point p1 = points[i], p2 = points[(i + 1) % 3];
            sides[i] = (int) Math.pow(p2.a - p1.a, 2) + (int) Math.pow(p2.b - p1.b, 2);
        }
        Arrays.sort(sides);
        System.out.println("Sides: " + Arrays.toString(sides));

        if(checkObtuseTriangle(sides)) {
            System.out.println("The points form an obtuse triangle!");
        }else if (checkRightTriangle(sides)) {
            throw new RightTriangle();
        } else if(checkAcuteTriangle(sides)) {
            throw new AcuteTriangle();
        } else {
            throw new ImpossibleTriangle();
        }
    }

    static boolean checkObtuseTriangle(int[] sides) {
        return sides[2] > sides[0] + sides[1];
    }

    static boolean checkRightTriangle(int[] sides) {
        return sides[2] == sides[0] + sides[1];
    }

    static boolean checkAcuteTriangle(int[] sides) {
        return sides[2] < sides[0] + sides[1];
    }
}
