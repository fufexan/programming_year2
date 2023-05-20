/*
 * 3. Write a class for determining a certain value from Fibonacci’s sequence.
 * The class has 2 methods, one for calculating and the other for displaying
 * the desired value. Use a synchronized multithreading mechanism in which one
 * process displays all the Fibonacci numbers smaller than the desired value
 * computed by the other process.
 */

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

class FibonacciFindNumber implements Runnable {
    int index, result;

    FibonacciFindNumber(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        int a = 0, b = 1;
        for (int i = 0; i < index; i++) {
            result = a + b;
            a = b;
            b = result;
        }
    }

    public int getNumber() {
        return result;
    }
}

class FibonacciGenerateNumbers implements Runnable {
    int number;

    FibonacciGenerateNumbers (int number) {
        this.number = number;
    }

    @Override
    public void run() {
        int a = 0, b = 1, result = 0;
        System.out.printf("Fibonacci sequence numbers up to %d are:\n", number);

        while (result < number) {
            result = a + b;
            a = b;
            b = result;
            System.out.printf("%d ", result);
        }
    }
}

public class Lab9_Ex3_FufezanMihai {
    public static void main(String[] args) {
        System.out.print("Enter the index of a Fibonacci sequence number: ");
        Scanner in = new Scanner(System.in);

        FibonacciFindNumber fibonacciFindNumber = new FibonacciFindNumber(in.nextInt());

        Thread thread1 = new Thread(fibonacciFindNumber);

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        FibonacciGenerateNumbers fibonacciGenerateNumbers = new FibonacciGenerateNumbers(fibonacciFindNumber.getNumber());
        Thread thread2 = new Thread(fibonacciGenerateNumbers);

        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
