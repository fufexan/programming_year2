/*
 * Implement the naive dots and crosses game (X-O) as an automated game. The
 * application will randomly select at each step a position from the board at
 * which to place the next symbol, alternating between X and O. The selected
 * position cannot be an already filled square. The game ends when either there
 * are no more empty squares on the board, or one of the symbols wins by
 * completing a line, a column or a diagonal. Display on the screen each step
 * of the algorithm as a matrix. Unfilled squares will be represented by the '*'
 * character.
 */

import java.util.Random;

public class TicTacToe {
    public static void main(String[] args) {
        Random rand = new Random();
        int d = 3;

        // get field dimensions from params
        if (args.length > 0) {
            d = Integer.parseInt(args[0]);
            System.out.println("Dimension is " + d);
        }

        // define field
        char[][] field = new char[d][d];
        for (int i = 0; i < d; i++)
            for (int j = 0; j < d; j++)
                field[i][j] = '*';

        // start logic
        int r, c;
        char p;
        for (int i = 0; i < d * d; i++) {
            p = (i % 2 == 0) ? 'X' : '0';

            do {
                r = rand.nextInt(d);
                c = rand.nextInt(d);
            } while (field[r][c] != '*');
            field[r][c] = p;

            displayField(field, d);

            if (checkWinState(field, d))
                break;
        }
    }

    private static boolean checkWinState(char[][] f, int d) {
        // 1 full diagonal
        char first = f[0][0];
        for (int i = 1; i < d && first != '*'; i++) {
            if (f[i][i] != first) {
                first = '*';
                break;
            }
        }
        if (first != '*') {
            System.out.printf("%c wins d!\n", first);
            return true;
        }
        first = f[0][d - 1];
        for (int i = 1; i < d && first != '*'; i++) {
            if (f[i][d - i - 1] != first) {
                first = '*';
                break;
            }
        }
        if (first != '*') {
            System.out.printf("%c wins rd!\n", first);
            return true;
        }

        // 1 full row
        boolean won = false;
        for (int i = 0; i < d && !won; i++) {
            first = f[i][0];
            for (int j = 0; j < d && first != '*'; j++) {
                if (f[i][j] != first) break;
                else if (j == d - 1) won = true;
            }
        }
        if (won) {
            System.out.printf("%c wins r!\n", first);
            return true;
        }

        // 1 full column
        for (int j = 0; j < d && !won; j++) {
            first = f[0][j];
            for (int i = 0; i < d && first != '*'; i++) {
                if (f[i][j] != first) break;
                else if (i == d - 1) won = true;
            }
        }
        if (won) {
            System.out.printf("%c wins c!\n", first);
            return true;
        }

        // draw
        boolean ended = true;
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                if (f[i][j] == '*') {
                    ended = false;
                    break;
                }
            }
        }
        if (ended) System.out.println("Draw!");
        return false;
    }

    private static void displayField(char[][] field, int d) {
        String inner = "───┼";
        String top = "───┬";
        String bottom = "───┴";
        System.out.printf("╭%s───╮\n", top.repeat(d - 1));

        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                System.out.printf("│ %c ", field[i][j]);
            }
            System.out.println("│");
            if (i != d - 1)
                System.out.printf("├%s───┤\n", inner.repeat(d - 1));
        }
        System.out.printf("╰%s───╯\n", bottom.repeat(d - 1));
    }
}
