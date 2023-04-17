/*
 * 1’. Instead of an interface that contains all the aforementioned methods,
 * implement 4 functional interfaces, one for each method. The interfaces will
 * be implemented within a single class. Instantiate the class and check the
 * implemented operations.
 */


import java.util.Scanner;

public class Math3 {
    public IAdd add = (a, b) -> a + b;
    public ISub sub = (a, b) -> a - b;
    public IMul mul = (a, b) -> a * b;
    public IDiv div = (a, b) -> a / b;
    public IPow pow = (a, b) -> {
        for (int i = 1; i < b; i++)
            a *= a;
        return a;
    };
    public ISqrt sqrt = Math::sqrt;
}

class Math3Driver {
    public static void main(String[] args) {
        Math3 math = new Math3();
        Scanner in = new Scanner(System.in);

        System.out.print("Enter 2 decimal point numbers: ");
        double a = in.nextDouble();
        double b = in.nextDouble();

        System.out.printf("%f + %f = %f\n", a, b, math.add.add(a, b));
        System.out.printf("%f - %f = %f\n", a, b, math.sub.sub(a, b));
        System.out.printf("%f * %f = %f\n", a, b, math.mul.mul(a, b));
        System.out.printf("%f / %f = %f\n", a, b, math.div.div(a, b));
        System.out.printf("%f ^ %d = %f\n", a, (int)b, math.pow.pow(a, (int)b));
        System.out.printf("√%f = %f\n", a, math.sqrt.sqrt(a));
    }
}