/*
 * 1. Write a Java program that defines an array of double values and read the
 * appropriate data from the keyboard. Handle the exception produced when the
 * code tries to access an element that has a negative index or an index
 * greater than the maximum number of elements (ArrayIndexOutOfBoundsException).
 * Display a significant message when the exception occurs. Consider a matrix
 * with a fixed number of elements for each line and protect the code against
 * the exception mentioned above. Consider also the case if each line has a
 * different number of elements.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("How many lines should the matrix have? ");
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        double[][] mat = new double[n][n];

        System.out.printf("Enter the elements (%d elements):\n", n*n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = in.nextDouble();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%f ", mat[i][j]);
            }
            System.out.println();
        }

        // try accessing invalid elements
        try {
            double x = mat[0][n];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("You tried to access an element outside the bounds of the matrix!");
        }

        double[][] mat1 = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
        System.out.println("\nPrinting a generated irregular matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    System.out.printf("%f ", mat1[i][j]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.print("x ");
                }
            }
            System.out.println();
        }
    }
}