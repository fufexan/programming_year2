/*
 * 10. Assume that there is a cryptographic algorithm which takes an input text
 * ‘A’ composed of lower and upper case characters. Separately a character
 * string ‘B’ is defined. Each character from B has an associated random
 * integer value between 1 and 100. The algorithm checks if the letters from B
 * are found in A and adds the associated numerical values. To the final sum
 * value, the algorithm also adds the positions from string A where characters
 * from string B were found. If the final sum is larger than 100, the
 * encryption was valid. Display a message with the result.
 * Example:
 * String A = "aTmPpDsst"
 * String B = "ams"
 * Associated numerical values for string B:  11 33 7
 * Sum: (11+33+7+7)+(1+3+7+8)=77  -> INVALID ENCRYPTION
 */

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class CryptographicAlgorithm {
    public static void main(String[] args) {
        System.out.println("Enter a string to validate the encryption:");

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        String A = in.next();
        HashMap<Character, Integer> B = new HashMap<>();
        B.put('a', rand.nextInt(100));
        B.put('m', rand.nextInt(100));
        B.put('s', rand.nextInt(100));

        AtomicInteger pos = new AtomicInteger();
        AtomicInteger sum = new AtomicInteger();
        A.chars().forEachOrdered((c) -> {
            pos.getAndIncrement();
            B.keySet().forEach((e) -> {
                if (c == e)
                    sum.addAndGet(B.get(e) + pos.get());
            });
        });

        System.out.println("The sum is " + sum);
        System.out.println("The encryption is " + ((sum.get() < 100) ? "in" : "") + "valid.");
    }
}
