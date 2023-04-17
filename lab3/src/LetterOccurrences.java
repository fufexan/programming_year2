import java.util.Arrays;
import java.util.Scanner;

/*
 * 2. Read a string from the standard input. Turn the string into a character
 * array. Look for in this array a character specified in the program. Display
 * the number of occurrences.
 */

public class LetterOccurrences {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a string:");
        String string = in.nextLine();
        char[] str = new char[string.length()];
        string.getChars(0, string.length(), str, 0);

        System.out.println("Enter a letter to search for: ");
        char letter = in.next().toLowerCase().charAt(0);

        if (letter >= 'a' && letter <= 'z') {
            Arrays.sort(str);
            System.out.printf("The number of occurrences for letter %c in the string is %d", letter, findLetter(letter, str));
        } else System.out.println("Please enter an English letter");
    }

    /**
     * @param letter letter to search for
     * @param str    char array to search in
     * @return number of occurrences of `letter`
     */
    private static int findLetter(char letter, char[] str) {
        int count = 0;

        for (char c : str) {
            if (c == letter) count++;
        }

        return count;
    }
}
