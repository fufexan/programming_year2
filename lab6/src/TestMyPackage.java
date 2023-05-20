/*
 * Lab 6, Fufezan Mihai, ex 3
 * 3. Define a package that declares an interface named Int1 (2 integer
 * variables and a sum() method that returns the sum of 2 integer values).
 * Include in the same package a class named Class1 (2 protected double
 * variables, constructor, setters and getters). In another source file,
 * add in the same package a new interface named Int2 (2 double variables and
 * a method named product() that returns the product of 2 double values).
 * Implement a distinct source file and import everything from the defined
 * package. Define a class named Class2 that is derived from Class1 and
 * implements both interfaces Int1 and Int2. Instantiate Class2 and call the
 * defined methods for determining the sum and product of some values read from
 * the keyboard.
 */

import mypackage.*;

import java.util.Scanner;

class Class2 extends Class1 implements Int1, Int2 {
    public Class2(double a, double b) {
        super(a, b);
    }

    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public double product(double a, double b) {
        return a * b;
    }
}

public class TestMyPackage {
    public static void main(String[] args) {
        System.out.print("Enter 2 real numbers: ");
        Scanner in = new Scanner(System.in);

        Class2 c = new Class2(in.nextDouble(), in.nextDouble());
        System.out.printf("%f + %f = %d\n", c.getA(), c.getB(), c.sum((int) c.getA(), (int) c.getB()));
        System.out.printf("%f * %f = %f\n", c.getA(), c.getB(), c.product(c.getA(), c.getB()));
    }
}
