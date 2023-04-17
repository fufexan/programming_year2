/*
 * 8. Write a Java application which defines an authentication key with the
 * format: XXXXX-XXXXX-XXXXX-XXXXX, where X is a character which can be either
 * a digit or a letter. The application should verify if this key has exactly 4
 * groups of characters with 5 characters each, and separated by the symbol
 * '-'. Also, compute the number of digits and letters from the authentication
 * key. The number of digits should be greater than the number of letters, and
 * the number of letters cannot be 0.
 * If any of the above conditions are not met, display the message:
 * “Invalid authentication key!”
 */

import java.util.Scanner;

public class AuthKey {
    public static void main(String[] args) {
        String key = readKey();
        if (validateKey(key))
            System.out.print("Valid key!");
        else
            System.err.print("Invalid authentication key!");
    }

    public static String readKey() {
        System.out.println("Enter your key:");
        Scanner in = new Scanner(System.in);

        return in.next();
    }

    public static boolean validateKey(String key) {
        int letters = 0;
        int digits = 0;
        String[] parts = key.split("-");

        if (parts.length != 4)
            return false;
        for (String i : parts) {
            if (i.length() != 5)
                return false;
            for (int j = 0; j < i.length(); j++) {
                char c = i.charAt(j);

                if (c >= 'a' && c <= 'z' || c > 'A' && c <= 'Z') {
                    letters++;
                } else if (c >= '0' && c <= '9') {
                    digits++;
                } else {
                    return false;
                }
            }
        }

        return letters < digits && letters > 0;
    }
}
