/*
 * Lab 7, Fufezan Mihai, ex 2
 * 2. Write a class called Calculator which has the methods to do addition,
 * subtraction, multiplication and division. The methods will take generic
 * input variables and will return the corresponding type. For example, the sum
 * of two integers should return an integer, and for floats it should return a
 * float. Same for division. Adding and subtracting is allowed for String
 * variables as well, but the multiplication and division will print an error
 * message.
 */

import java.util.Scanner;

public class Calculator {
    public static <T extends Number> T add(T a, T b) {
        if(a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() + b.intValue());
        } else if (a instanceof Float) {
            return (T) Float.valueOf(a.floatValue() + b.floatValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
        } else {
            throw new IllegalArgumentException("add() argument is not of type Number");
        }
    }

    public static <T extends Number> T subtract(T a, T b) {
        if(a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() - b.intValue());
        } else if(a instanceof Float) {
            return (T) Float.valueOf(a.floatValue() - b.floatValue());
        } else if(a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() - b.doubleValue());
        } else {
            throw new IllegalArgumentException("Unsupported type for subtraction.");
        }
    }

    public static <T extends Number> T multiply(T a, T b) {
        if(a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() * b.intValue());
        } else if(a instanceof Float) {
            return (T) Float.valueOf(a.floatValue() * b.floatValue());
        } else if(a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() * b.doubleValue());
        } else {
            throw new IllegalArgumentException("Unsupported type for multiplication.");
        }
    }

    public static <T extends Number> T divide(T a, T b) {
        if(b.doubleValue() == 0.0) {
            throw new ArithmeticException("Division by zero.");
        }
        if(a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() / b.intValue());
        } else if(a instanceof Float) {
            return (T) Float.valueOf(a.floatValue() / b.floatValue());
        } else if(a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() / b.doubleValue());
        } else {
            throw new IllegalArgumentException("Unsupported type for division.");
        }
    }

    public static String add(String a, String b) {
        return a + b;
    }

    public static String subtract(String a, String b) {
        return a.replace(b, "");
    }

    public static String multiply(String a, String b) {
        throw new UnsupportedOperationException("String multiplication is not supported.");
    }

    public static String divide(String a, String b) {
        throw new UnsupportedOperationException("String division is not supported.");
    }
}

class CalculatorMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("\nEnter two integers: ");
        int i1, i2;
        i1 = in.nextInt();
        i2 = in.nextInt();
        
        System.out.printf("%d + %d = %d\n", i1, i2, Calculator.add(i1, i2));
        System.out.printf("%d - %d = %d\n", i1, i2, Calculator.subtract(i1, i2));
        System.out.printf("%d * %d = %d\n", i1, i2, Calculator.multiply(i1, i2));
        System.out.printf("%d / %d = %d\n", i1, i2, Calculator.divide(i1, i2));

        System.out.print("\nEnter two floats: ");
        float f1, f2;
        f1 = in.nextFloat();
        f2 = in.nextFloat();
        
        System.out.printf("%f + %f = %f\n", f1, f2, Calculator.add(f1, f2));
        System.out.printf("%f - %f = %f\n", f1, f2, Calculator.subtract(f1, f2));
        System.out.printf("%f * %f = %f\n", f1, f2, Calculator.multiply(f1, f2));
        System.out.printf("%f / %f = %f\n", f1, f2, Calculator.divide(f1, f2));

        System.out.print("\nEnter two doubles: ");
        double d1, d2;
        d1 = in.nextDouble();
        d2 = in.nextDouble();
       
        System.out.printf("%f + %f = %f\n", d1, d2, Calculator.add(d1, d2));
        System.out.printf("%f - %f = %f\n", d1, d2, Calculator.subtract(d1, d2));
        System.out.printf("%f * %f = %f\n", d1, d2, Calculator.multiply(d1, d2));
        System.out.printf("%f / %f = %f\n", d1, d2, Calculator.divide(d1, d2));

        System.out.println("\nEnter two strings: ");
        String s1, s2;
        in.nextLine();
        s1 = in.nextLine();
        s2 = in.nextLine();
        
        System.out.printf("%s + %s = %s\n", s1, s2, Calculator.add(s1, s2));
        System.out.printf("%s - %s = %s\n", s1, s2, Calculator.subtract(s1, s2));
        System.out.printf("%s * %s = %s\n", s1, s2, Calculator.multiply(s1, s2));
        System.out.printf("%s / %s = %s\n", s1, s2, Calculator.divide(s1, s2));
    }
}