/*
 * 7. Read from the keyboard an integer value bigger than 16.777.216. Use bit
 * masks for isolating each of the 4 bytes of the read value. Display the
 * initial and the isolated values as decimal, binary and hexadecimal strings.
 */

import java.util.Scanner;

public class IsolatedBitMask {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // ask for input
        System.out.print("Enter an integer value greater than 16,777,216: ");
        int val = in.nextInt();

        // validate input
        if (val <= 1 << 24) {
            System.err.println("Please enter an int value greater than 16,777,216.");
            System.exit(1);
        }

        // get number of bytes necessary for storing the value
        // it is given by log_2(val) + 1
        int bytes = (int) (Math.log(val) / Math.log(2) / 4 + 1);
        System.out.printf("%d 4-bit groups found\n\n", bytes);

        printBase(val);

        for (int i = 0; i < bytes; i++) {
            // create bitmask based on byte position
            int bitmask = 0xF << i * 4;
            // read byte value
            int x = val & bitmask;

            System.out.printf("\nGroup %d, bitmask %s", i, Integer.toBinaryString(bitmask));
            printBase(x);
        }
    }

    private static void printBase(int x) {
        System.out.printf("%d in binary is %s\n", x, Integer.toBinaryString(x));
        System.out.printf("%d in hexadecimal is %s\n", x, Integer.toHexString(x));
        System.out.printf("%d in octal is %s\n", x, Integer.toOctalString(x));
    }
}
