/* 3. Starting from the previous problem, copy the first 3 characters of the
 * array to another array and display the obtained result(use the arraycopy()
 * method from the System class).
 */

import java.util.Arrays;
import java.util.Scanner;

public class ArrayCopy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a string:");
        String string = in.nextLine();
        char[] str = new char[string.length()];
        string.getChars(0, string.length(), str, 0);

        char[] str3 = new char[3];
        System.arraycopy(str, 0, str3, 0, 3);
        System.out.printf("The original string is %s\n and the substring is %s\n", String.valueOf(str), String.valueOf(str3));
    }
}