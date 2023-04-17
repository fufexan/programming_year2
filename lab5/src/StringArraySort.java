/*
 * 5. Define a String Array. Using lambda expressions sort it by the following
 * criteria: length (small->large), inverse length (large->small), alphabetical
 * order, the strings which start with the letter M are first, then come the rest.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class StringArraySort {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        String str;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter some strings. Enter 'stop' when you're done.");
        for (str = in.nextLine(); !str.matches("stop");) {
            strings.add(str);
            str = in.nextLine();
        }

        // sort
        System.out.println("\nWhat criterion to sort by? (length, invlength, alphabetical, letter): ");
        String criteria = in.next();

        switch(criteria) {
            case "length" -> strings.sort((a, b) -> a.length() - b.length());
            case "invlength" -> strings.sort((a, b) -> b.length() - a.length());
            case "alphabetical" -> strings.sort((a, b) -> a.compareTo(b));
            case "letter" -> {
                System.out.println("Enter the character to look for: ");
                String chr = in.next();
                strings.sort((a, b) -> {
                    if (a.toLowerCase().charAt(0) == chr.toLowerCase().charAt(0))
                        return -1;
                    return 1;
                });
            }
            default -> System.out.println("Unknown criterion.");
        }

        System.out.println(strings);
    }
}
