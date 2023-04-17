/*
 * 5. Build a Java application that tests the new methods of the String class,
 * introduced in Java11.
 */

import java.util.List;

public class Java11String {
    public static void main(String[] args) {
        String multiline = "Hello there  \n this is a multiline string  \n\n  " + "ha".repeat(2);
        List<String> lines = multiline.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .toList();

        System.out.printf("Original string:\n%s\n\n", multiline);
        System.out.println("Resulting string:");
        for (String s : lines) {
            System.out.printf("%s. ", s);
        }
    }
}
