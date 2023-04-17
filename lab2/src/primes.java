import java.util.ArrayList;
import java.util.Scanner;

/*
 * 5. Write a Java application where you can read several integers from the
 * keypad and check that they are prime numbers. The number of read values is
 * taken from the KB or command line.
 */

public class primes {
    public static void main(String[] args) {
        System.out.print("Enter the amount of numbers you want to check for primeness: ");

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        System.out.print("Enter the numbers: ");
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < num; i++) {
            numbers.add(in.nextInt());
        }
        
        numbers.forEach(e -> System.out.printf("%d is%s prime\n", e, checkInt(e) ? "" : "n't"));
    }

    private static boolean checkInt(Integer x) {
        if(x == 2)
            return true;
        else if(x == 1 || x % 2 == 0)
            return false;
        else {
            for(int i = 3; i * i <= x; i += 2)
                if(x % i == 0) return false;
        }

        return true;
    }
}
