/*
 * 1. Consider a Java interface that contains the prototypes of the methods of
 * addition, subtraction, multiplication, division, square root and raising a
 * number to a certain power. All methods will have two double type parameters
 * and specify the returned double type. Implement the interface so that
 * operations are defined within a class. Instantiate the class and check the
 * implemented operations.
 */


import java.util.Scanner;

interface MathInterface1 {
    double add(double a, double b);
    double sub(double a, double b);
    double mul(double a, double b);
    double div(double a, double b);
    double pow(double x, int p);
    double sqrt(double x);
}

public class Math1 implements MathInterface1 {

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double sub(double a, double b) {
        return a - b;
    }

    @Override
    public double mul(double a, double b) {
        return a * b;
    }

    @Override
    public double div(double a, double b) {
        return a / b;
    }

    @Override
    public double pow(double x, int p) {
        for (int i = 1; i < p; i++) {
            x *= x;
        }
        return x;
    }

    @Override
    public double sqrt(double x) {
        return Math.sqrt(x);
    }
}

class Math1Driver {
    public static void main(String[] args) {
        Math1 math = new Math1();
        Scanner in = new Scanner(System.in);

        System.out.print("Enter 2 decimal point numbers: ");
        double a = in.nextDouble();
        double b = in.nextDouble();

        System.out.printf("%f + %f = %f\n", a, b, math.add(a, b));
        System.out.printf("%f - %f = %f\n", a, b, math.sub(a, b));
        System.out.printf("%f * %f = %f\n", a, b, math.mul(a, b));
        System.out.printf("%f / %f = %f\n", a, b, math.div(a, b));
        System.out.printf("%f ^ %d = %f\n", a, (int)b, math.pow(a, (int)b));
        System.out.printf("√%f = %f\n", a, math.sqrt(a));
    }
}