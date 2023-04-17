/*
 * 4. Consider the Fraction class that has two protected attributes a and b for
 * the counter and denominator, two set() and get() methods for each of the
 * class attributes. Define an explicit constructor without parameters that
 * initiates a with 0 and b with 1, and an explicit constructor with two
 * parameters that can be called if it is checked whether a fraction can be
 * defined (b! = 0). Define a method simplify() that simplifies and returns a
 * Fraction object by calling the int greatestCommonDivider(int, int) method
 * (based on divisions). Define a method for adding two Fraction objects, which
 * returns a Fraction object. Define a ExtendedFraction class derived from
 * Fraction, which will have a constructor with parameters (which calls the
 * constructor from the base class) and which will redefine the method
 * simplify() using an int greatestCommonDivider(int, int) algorithm based on
 * subtractions. Add a method for subtracting two fractions. Instantiate two
 * Fraction objects without parameters. Set the attributes of the data objects
 * read from the keyboard. Display the original attributes of the objects and
 * the new defined attributes. Simplify, add and display results. Instantiate
 * two ExtendedFraction objects with data read from the keyboard. Simplify,
 * add and subtract objects and display results. Make an upcast from
 * ExtendedFraction to Fraction and try to subtract the items. All operations
 * will be called from the main() method.
 */

import java.util.Scanner;

public class Fraction {
    int a, b;

    public Fraction() {
        a = 0;
        b = 1;
    }

    public Fraction(int a, int b) {
        if (b == 0) {
            System.err.printf("Fraction(): a = %d, b = %d\n", a, b);
            throw new ArithmeticException();
        }
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        if (b == 0) {
            System.err.println("setB(): b is zero");
            throw new ArithmeticException();
        }
        this.b = b;
    }

    public Fraction simplify() {
        int gcd = greatestCommonDivisor(a, b);
        int x = a / gcd;
        int y = b / gcd;
        return new Fraction(x, y);
    }

    private static int greatestCommonDivisor(int x, int y) {
        if (y == 0)
            return x;
        return greatestCommonDivisor(y, x % y);
    }

    public static Fraction add(Fraction x, Fraction y) {
        int denominator, numerator;

        if(x.getB() == y.getB())
            return new Fraction(x.getA() + y.getA(), x.getB());

        if (x.getB() % y.getB() == 0) {
            denominator = x.getB() / y.getB();
            numerator = x.getA() + y.getA() * denominator;
        } else if (y.getB() % x.getB() == 0) {
            denominator = y.getB() / x.getB();
            numerator = x.getA() * denominator + y.getA();
        } else {
            denominator = x.getB() * y.getB();
            numerator = x.getA() * y.getB() + y.getA() * x.getB();
        }

        return new Fraction(numerator, denominator);
    }
}

class ExtendedFraction extends Fraction {
    public ExtendedFraction(int a, int b) {
        super(a, b);
    }

    private static int greatestCommonDivisor(int x, int y) {
        while (x != y) {
            if (x > y)
                x = x - y;
            else
                y = y - x;
        }
        return x;
    }

    @Override
    public ExtendedFraction simplify() {
        int gcd = greatestCommonDivisor(a, b);
        int x = a / gcd;
        int y = b / gcd;
        return new ExtendedFraction(x, y);
    }

    public static ExtendedFraction subtract(Fraction x, Fraction y) {
        int denominator, numerator;

        if(x.getB() == y.getB())
            return new ExtendedFraction(x.getA() - y.getA(), x.getB());

        if (x.getB() % y.getB() == 0) {
            denominator = x.getB() / y.getB();
        } else if (y.getB() % x.getB() == 0) {
            denominator = y.getB() / x.getB();
        } else {
            denominator = x.getB() * y.getB();
        }

        numerator = x.getA() * denominator - y.getA() * denominator;
        return new ExtendedFraction(numerator, denominator);
    }
}

class FunctionDriver {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(), f2 = new Fraction();
        Scanner in = new Scanner(System.in);

        System.out.printf("Fraction f1: %d / %d\n", f1.getA(), f1.getB());
        System.out.printf("Fraction f2: %d / %d\n", f2.getA(), f2.getB());

        System.out.print("\nEnter new values for f1: ");
        f1.setA(in.nextInt());
        f1.setB(in.nextInt()); // TODO: encapsulate in try block

        System.out.print("Enter new values for f2: ");
        f2.setA(in.nextInt());
        f2.setB(in.nextInt()); // TODO: encapsulate in try block

        f1 = f1.simplify();
        f2 = f2.simplify();
        System.out.printf("\nFraction f1 simplified: %d / %d\n", f1.getA(), f1.getB());
        System.out.printf("Fraction f2 simplified: %d / %d\n", f2.getA(), f2.getB());

        Fraction fadd = Fraction.add(f1, f2);
        System.out.printf("\nFraction f1 + f2:\n%d/%d + %d/%d = %d/%d\n", f1.getA(), f1.getB(), f2.getA(), f2.getB(), fadd.getA(), fadd.getB());

        // extended fractions
        System.out.print("\nEnter values for Extended Fraction e1: ");
        ExtendedFraction e1 = new ExtendedFraction(in.nextInt(), in.nextInt());

        System.out.print("Enter values for Extended Fraction e2: ");
        ExtendedFraction e2 = new ExtendedFraction(in.nextInt(), in.nextInt());

        e1 = e1.simplify();
        e2 = e2.simplify();
        System.out.printf("\nFraction e1 simplified: %d / %d\n", e1.getA(), e1.getB());
        System.out.printf("Fraction e2 simplified: %d / %d\n", e2.getA(), e2.getB());

        f1 = e1;
        f2 = e2;

        Fraction esub = ExtendedFraction.subtract(f1, f2);
        System.out.printf("\nFraction e1 - e2 (upcasted):\n%d/%d - %d/%d = %d/%d", f1.getA(), f1.getB(), f2.getA(), f2.getB(), esub.getA(), esub.getB());
    }
}
