/*
 * 2. Write a Java application with a thread that generates 30 random numbers
 * between 0 and 30. Another thread displays the area of the circles having as
 * radii the values divisible by 3 generated by the first thread.
 */

import java.util.Random;

class NumberGenerator implements Runnable {
    Random r = new Random();
    int[] numbers;

    NumberGenerator() {
        numbers = new int[30];
    }

    @Override
    public void run() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(31);
        }
    }

    public int[] getNumbers () {
        return numbers;
    }
}

class AreaCalculator implements Runnable {
    int[] numbers;

    AreaCalculator(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        for (int number : numbers) {
            if (number % 3 == 0) {
                double area = Math.PI * number * number;
                System.out.printf("Circle with radius %d has area %f\n", number, area);
            }
        }
    }
}

public class Lab9_Ex2_FufezanMihai {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        new Thread(numberGenerator).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new AreaCalculator(numberGenerator.getNumbers())).start();
    }
}
