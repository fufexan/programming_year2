import java.util.ArrayList;
import java.util.Scanner;

/*
 * 4. Write a Java application where you read from the keyboard an integer and
 * display all the dividers of the number you read.
 */
public class divnum {
    public static ArrayList<Integer> divs(int x) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= x / 2; i++) {
            if (x % i == 0) list.add(i);
        }

        return list;
    }
    public static void main(String[] args) {
        System.out.print("Enter an integer: ");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        System.out.printf("The divisors of %d are:", num);
        ArrayList<Integer> list = divs(num);
        list.forEach(div -> System.out.printf(" %d", div));
    }
}
