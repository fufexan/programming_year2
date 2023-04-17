import java.util.Scanner;

/*
 * 2. Write a Java application where you read from the keyboard an int value
 * and the factorial of the number read, is displayed.
 */

public class Factorial {
    public static int factorial(int x) {
        if (x == 0) {
            return 1;
        } else {
            return x * factorial(x - 1);
        }
    }
    public static void main(String[] args) {
        System.out.print("Enter an integer to factorialize: ");

        Scanner in = new Scanner(System.in);
        int x = in.nextInt();

        System.out.println("The factorial of " + x + " is " + factorial(x));
    }
}
