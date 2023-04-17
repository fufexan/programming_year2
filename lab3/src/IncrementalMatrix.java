/*
 * 8. Read from the keyboard the elements of a matrix of integer values with m
 * lines (m taken from the command line). For each line the number of elements
 * will increase by 1 compared to the previous line, the first line having only
 * one element. Implement the methods that:
 * - display the matrix, line by line and column by column;
 * - eliminate from the matrix (turns into 0) the values that are outside the
 *   interval defined by 2 specified limits;
 * - display the existent neighbour values of an element identified by its
 *   indexes (sent as parameters);
 */

import java.util.Scanner;

public class IncrementalMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        if (args.length == 0) {
            System.out.println("Pass the number of rows as an argument");
            System.exit(1);
        }
        int rows = Integer.parseInt(args[0]);

        int[][] matrix = new int[rows][rows];

        System.out.printf("Enter the elements of the matrix (%d elements):\n", rows * (rows + 1) / 2);

        readMatrix(in, rows, matrix);
        printMatrix(rows, matrix);
        boundaries(matrix, rows);
        printMatrix(rows, matrix);
        findNeighbours(matrix, rows, in);
    }

    private static void printMatrix(int rows, int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void readMatrix(Scanner in, int rows, int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i + 1; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
    }

    private static void boundaries(int[][] matrix, int rows) {
        Scanner in = new Scanner(System.in);

        System.out.println("Specify the interval for the numbers should be kept (2 values): ");
        int lower_bound = in.nextInt();
        int upper_bound = in.nextInt();

        // check order and swap if needed
        if (lower_bound > upper_bound) {
            lower_bound ^= upper_bound;
            upper_bound ^= lower_bound;
            lower_bound ^= upper_bound;
        }

        // get rid of elements out of bounds
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (matrix[i][j] < lower_bound || matrix[i][j] > upper_bound) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    private static void findNeighbours(int[][] matrix, int rows, Scanner in) {
        System.out.print("Enter the row and column of the element whose neighbours to display: ");
        int row = in.nextInt();
        int col = in.nextInt();

        if (row > 0) {
            System.out.println("Top neighbour: " + matrix[row - 1][col]);
        }
        if (row < rows - 1) {
            System.out.println("Bottom neighbour: " + matrix[row + 1][col]);
        }
        if (col > 0) {
            System.out.println("Left neighbour: " + matrix[row][col - 1]);
        }
        if (col < rows - 1) {
            System.out.println("Bottom neighbour: " + matrix[row][col + 1]);
        }
    }
}
