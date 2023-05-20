/*
 * 4. Write a Java app which uses the synchronized method access for mutual
 * exclusion. Create 3 separate threads which simultaneously call methods to
 * increment and decrement a separate class' class variable. Check if the
 * results are what you expect them to be. Remove the synchronized blocks and
 * reevaluate the results.
 */

class Count {
    int count = 0;

    public synchronized void increment() {
        count++;
    }
    public synchronized void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }
}

class Increment implements Runnable {
    Count count;

    Increment(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        count.increment();
    }
}

class Decrement implements Runnable {
    Count count;

    Decrement(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        count.decrement();
    }
}

public class Lab9_Ex4_FufezanMihai {
    public static void main(String[] args) {
        Count count = new Count();
        Increment increment = new Increment(count);
        Decrement decrement = new Decrement(count);

        Thread tinc = new Thread(increment);
        Thread tdec = new Thread(decrement);

        try {
            tinc.join();
            tdec.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("Count is %d\n", count.getCount());
    }
}
