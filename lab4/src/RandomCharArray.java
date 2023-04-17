/*
 * 6. Define a one-dimensional array of char type, less than a value n
 * introduced from the keyboard. Each value contains some randomly generated
 * alphanumerical characters. Generate a String object using the array.
 * Display the initial content of the array and after that, process all the
 * elements so that all numbers will be replaced with ‘*’. Display the result.
 */

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class RandomCharArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Enter the size of the new char array: ");
        char[] array = new char[in.nextInt()];

        System.out.println("The generated character array is:");
        for (int i = 0; i < array.length; i++) {
            // generate any char from 0 to z
            array[i] = (char) rand.nextInt(30, 122);
            System.out.print(array[i]);

            if (array[i] > '0' && array[i] <= '9') {
                array[i] = '*';
            }
        }

        String str = String.valueOf(array);
        System.out.printf("\n\nThe resulting string is:\n%s\n", str);
    }
}
