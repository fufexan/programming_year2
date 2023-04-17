/*
 * 4. Write a Java application which defines an integer value and displays it
 * as a binary, octal and hexadecimal string. Write various bases conversion methods.
 */

import java.util.Scanner;

public class Conversions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter an integer value: ");
        int value = in.nextInt();
        System.out.println("The number entered is");
        System.out.println(Integer.toBinaryString(value) + " in binary");
        System.out.println(Integer.toHexString(value) + " in hexadecimal");
        System.out.println(Integer.toOctalString(value) + " in octal");
    }
}
