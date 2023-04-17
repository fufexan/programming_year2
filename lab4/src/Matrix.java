/*
 * 3. Write a Java class that models a matrix of integer values. The dimensions
 * and the array of elements are private attributes and are controlled using
 * appropriate setter-getter methods. Write the methods for displaying the
 * matrix, for determining and returning the number of 9 adjacent elements cells
 * that don’t differ with more than 5% from a threshold value.
 */

import java.util.Scanner;

public class Matrix {
    int[][] matrix = new int[][]{};
    int rows = 0, columns = 0;

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        resizeMatrix(rows, this.columns);
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        resizeMatrix(this.rows, columns);
    }

    private void resizeMatrix(int rows, int columns) {
        int r = Math.max(rows, this.rows);
        int c = Math.max(columns, this.columns);
        int[][] mat = new int[r][c];

        for (int i = 0; i < r; i++) {
            System.arraycopy(matrix[i], 0, mat[i], 0, c);
        }

        this.matrix = mat;
        this.rows = r;
        this.columns = c;
    }

    public void getAdjacent(int i, int j, int threshold) {
        if (i > rows || j > columns) {
            System.err.println("Element's position doesn't exist in the matrix!");
            return;
        }

        int T = (int) ((int) threshold + 0.05f * threshold);
        int t = (int) ((int) threshold - 0.05f * threshold);

        for (int k = i - 1; k < i + 2; k++) {
            for (int l = j - 1; l < j + 2; l++) {
                try {
                    if (matrix[k][l] >= t && matrix[k][l] <= T)
                        System.out.printf("%d ", matrix[k][l]);
                    else
                        System.out.print("0 ");
                } catch (IndexOutOfBoundsException e) {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public void displayMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                System.out.printf("%d ", matrix[i][j]);
            System.out.println();
        }
    }

    public void readMatrix() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the new matrix sizes (rows columns): ");
        rows = in.nextInt();
        columns = in.nextInt();
        matrix = new int[rows][columns];

        System.out.printf("Enter the matrix elements (%d elements):\n", rows * columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                matrix[i][j] = in.nextInt();
        }
    }
}

class MatrixDriver {
    public static void main(String[] args) {
        Matrix matrix = new Matrix();

        Scanner in = new Scanner(System.in);

        matrix.readMatrix();

        matrix.displayMatrix();

        System.out.print("Enter an element to get its adjacent elements (row column), and a threshold: ");
        matrix.getAdjacent(in.nextInt(), in.nextInt(), in.nextInt());
    }
}
