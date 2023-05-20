/*
 * Lab 7, Fufezan Mihai, ex 1
 * 1. Create an interface called Generator<T> with a single method next(T var).
 * Implement the interface so that you can generate the following values when
 * applying it to certain data types (Integer, Character, etc.). The class will
 * be instantiated in the main() method, located in a separate class.
 */

import java.util.Scanner;

public interface Generator<T> {
    T next(T var);
}

class IntegerGenerator implements Generator<Integer> {
    public Integer next(Integer var) {
        return var + 1;
    }
}

class CharacterGenerator implements Generator<Character> {
    public Character next(Character var) {
        char nextChar = (char) (var + 1);
        if (nextChar > 'z') {
            nextChar = 'a';
        }
        return nextChar;
    }
}

class GeneratorMain {
    public static void main(String[] args) {
        Generator<Integer> intgen = new IntegerGenerator();
        Generator<Character> chargen = new CharacterGenerator();

        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int i = in.nextInt();
        System.out.print("Enter a character: ");
        char c = in.next().charAt(0);

        System.out.printf("%d.next() = %d\n", i, intgen.next(i));
        System.out.printf("%c.next() = %c\n", c, chargen.next(c));
    }
}
