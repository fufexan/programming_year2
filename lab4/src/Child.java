/*
 * 7. Write an application which defines a class named Child. Define the methods
 * and member variables for this class which enables a Child object to store/do
 * the following:
 * - the name of the child
 * - the child’s birthday
 * - the child can introduce him/herself by "saying": Hello my name is ...
 * - the child can tell his/her age
 * - the child can add two numbers smaller than 10 and return the result like
 * so: The sum of X and Y is equal to Z
 * - the child knows how to say Goodbye!
 * - the child can speak the alphabet both in direct and inverse order
 * - the child can color a chess board given its dimensions by using
 * alternative colors (for the colors use the symbols 1 and 0)
 * - the child can play dots and crosses (X-0) by him/herself 😊 (use the
 * application developed in the previous assignment)
 * Remarks: the child’s name and birthday cannot be accessed from outside the
 * class.
 * All the information about a Child will be filled-in using a Child object and
 * its associated methods and variables. The interaction with the child will be
 * done through an object which is instantiated in the main method.
 */

import java.time.LocalDate;
import java.time.Period;

public class Child {
    String name;
    LocalDate birthday;

    Child(String name, LocalDate date) {
        this.name = name;
        this.birthday = date;
    }

    public void sayHello() {
        System.out.printf("Hello, my name is %s!\n", name);
    }

    public void sayAge() {
        int age = Period.between(birthday, LocalDate.now()).getYears();
        System.out.printf("I'm %d years old.\n", age);
    }

    public void sayGoodbye() {
        System.out.println("Goodbye!");
    }

    public void addNumbers(int a, int b) {
        if (a > 10 || b > 10 || a < 0 || b < 0) {
            System.out.println("I don't know how to add numbers this big!");
            return;
        }

        System.out.printf("The sum of %d and %d is %d.\n", a, b, a + b);
    }

    public void colorChessBoard(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.printf("%d ", (i + j) % 2);
            System.out.println();
        }
    }

    public void sayAlphabet() {
        for (char c = 'a'; c <= 'z'; c++)
            System.out.printf("%c ", c);
        System.out.println();
        for (char c = 'z'; c >= 'a'; c--)
            System.out.printf("%c ", c);
    }

    public void playTicTacToe() {
        TicTacToe.main(new String[]{"3"});
    }
}

class ChildDriver {
    public static void main(String[] args) {
        Child c = new Child("Charlie", LocalDate.of(2017, 7, 17));

        c.sayHello();
        System.out.println();
        c.sayAge();
        System.out.println();
        c.addNumbers(3, 6);
        System.out.println();
        c.colorChessBoard(5);
        System.out.println();
        c.sayAlphabet();
        System.out.println();
        c.playTicTacToe();
        System.out.println();
        c.sayGoodbye();
    }
}
