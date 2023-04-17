import java.util.Scanner;

/*
 * 3. Write a Java application that reads from the keyboard 2 integer values
 * and displays the gcd of the values.
 */

public class gcd {
    public static int gcd(int x, int y) {
        while (x != y)
            if (x > y)
                x = x - y;
            else
                y = y - x;
        return x;
    }

    public static void main(String[] args) {
        System.out.print("Enter 2 integers to compute their greatest common divisor: ");

        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();

        System.out.printf("GCD(%d,%d) = %d", x, y, gcd(x, y));
    }
}
