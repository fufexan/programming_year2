/*
 * 1. Write a Java application that reads an int value. If the int value is
 * between 1-12, the corresponding string month will be displayed. If the value
 * entered is a string and if it corresponds to a month of the year, display
 * the numeric value of the month.
 */

import java.util.Arrays;
import java.util.Scanner;

public class DisplayMonth {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        System.out.print("Enter a number between 1 and 12, or the name of a month: ");
        String input = in.next();
        try {
            int num = Integer.parseInt(input);
            displayName(num, months);
        } catch (NumberFormatException nfe) {
            displayNumber(input, months);
        }
    }

    private static void displayName(int num, String[] months) {
        if (num < 1 || num > 12) {
            System.out.println("Month number is invalid.");
            return;
        }

        System.out.println("The name of month number " + num + " is " + months[num - 1]);
    }

    private static void displayNumber(String input, String[] months) {
        // format input as Capitalized
        input = input.toLowerCase();
        input = input.substring(0, 1).toUpperCase() + input.substring(1);

        // search for month in array
        int index = Arrays.asList(months).indexOf(input);
        if (index == -1) {
            System.out.println("Month name is invalid.");
            return;
        }

        System.out.println("The month number of " + input + " is " + (index + 1));
    }
}