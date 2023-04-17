/*
 * 6. Write a Java program that generates 2 random values and performs some
 * mathematical operations on them.
 */

import java.util.concurrent.ThreadLocalRandom;

public class RandomIntsOperations {
    public static void main(String[] args) {
        int a = ThreadLocalRandom.current().nextInt(1001);
        int b = ThreadLocalRandom.current().nextInt(1001);

        System.out.printf("Random number addition:\n%d x %d = %d\n", a, b, (long) a + (long) b);
        System.out.printf("Random number subtraction:\n%d x %d = %d\n", a, b, (long) a - (long) b);
        System.out.printf("Random number multiplication:\n%d x %d = %d\n", a, b, (long) a * (long) b);
        System.out.printf("Random number division:\n%d x %d = %d\n", a, b, (long) a / (long) b);
    }
}
