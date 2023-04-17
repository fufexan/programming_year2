/*
 * 1’. Instead of an interface that contains all the aforementioned methods,
 * implement 4 functional interfaces, one for each method. The interfaces will
 * be implemented within a single class. Instantiate the class and check the
 * implemented operations.
 */


import java.util.Scanner;

@FunctionalInterface
interface IAdd {
    double add(double a, double b);
}

@FunctionalInterface
interface ISub {
    double sub(double a, double b);
}

@FunctionalInterface
interface IMul {
    double mul(double a, double b);

}

@FunctionalInterface
interface IDiv {
    double div(double a, double b);
}

@FunctionalInterface
interface IPow {
    double pow(double x, int p);

}

@FunctionalInterface
interface ISqrt {
    double sqrt(double x);
}
public class Math2 implements ISub, IAdd, IMul, IDiv, IPow, ISqrt {

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

class Math2Driver {
    public static void main(String[] args) {
        Math2 math = new Math2();
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