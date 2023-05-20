/*
 * 1. Using a KB reading mechanism (BufferedReader/InputStreamReader) input:
 * a message of String type, a day as an integer, a month as a String and a
 * year as an integer variable. The process will end by passing to a new line,
 * or by typing a special String. Separate and display the tokens on different
 * rows. Display all fields extracted from the stream as appeared.
 * Recommendation: use the StreamTokenizer class, the attributes sval, nval and
 * the TT_EOL constant. Consider the case in which the application is not aware
 * of the entered data type (numbers, words). Use the constants TT_NUMBER,
 * TT_WORD.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Lab8_Ex1_FufezanMihai {
    public static void main(String[] args) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StreamTokenizer streamTokenizer = new StreamTokenizer(bufferedReader);
            streamTokenizer.eolIsSignificant(true);

            String message = null, month = null;
            int day = 0, year = 0;

            System.out.println("Enter a message, a day, a month, and a year (or type 'quit' to exit):");

            while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                    String token = streamTokenizer.sval;
                    if (token.equalsIgnoreCase("quit")) {
                        break;
                    } else if (message == null) {
                        message = token;
                    } else if (month == null) {
                        month = token;
                    }
                } else if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    double token = streamTokenizer.nval;
                    if (day == 0) {
                        day = (int) token;
                    } else if (year == 0) {
                        year = (int) token;
                    }
                } else if (streamTokenizer.ttype == StreamTokenizer.TT_EOL) {
                    System.out.println("Message: " + message);
                    System.out.println("Day: " + day);
                    System.out.println("Month: " + month);
                    System.out.println("Year: " + year);
                    message = null;
                    day = 0;
                    month = null;
                    year = 0;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
