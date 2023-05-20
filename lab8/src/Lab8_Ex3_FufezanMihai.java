/*
 * 3. Read from the keyboard some strings representing dates formatted as
 * DD/MM/YYYY. Print the dates as DD month YYYY, where month is the expanded
 * version of the MM, and also display messages if the year is leap. The
 * program exits when the user types in X or x from KB. You may use
 * DateFormatSymbols class for month conversion.
 */

import java.io.*;
import java.text.DateFormatSymbols;

public class Lab8_Ex3_FufezanMihai {
    static int day = 0;
    static int month = 0;
    static int year = 0;
    static DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
    static String[] months = dateFormatSymbols.getMonths();

    public static void main(String[] args) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StreamTokenizer streamTokenizer = new StreamTokenizer(bufferedReader);
            streamTokenizer.eolIsSignificant(true);

            while(streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                if(streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    int token = (int) streamTokenizer.nval;
                    if (day == 0) {
                        day = token;
                    } else if (month == 0) {
                        month = token;
                    } else if (year == 0) {
                        year = token;
                    }
                } else if (streamTokenizer.ttype == StreamTokenizer.TT_EOL) {
                    printDate();
                } else if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                    String token = streamTokenizer.sval;
                    if (token.equalsIgnoreCase("x")) {
                        printDate();
                        System.exit(1);
                    }
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    static void printDate() {
        System.out.println("Day: " + day);
        System.out.println("Month: " + months[month - 1]);
        System.out.println("Year: " + year);
        if (isLeapYear(year)) {
            System.out.println("It's a leap year!");
        }

        day = 0;
        month = 0;
        year = 0;
    }
}
