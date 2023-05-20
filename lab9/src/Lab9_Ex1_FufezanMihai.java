/*
 * 1. Write a Java application which contains a class which implements the
 * Runnable interface. The class' constructor sets the name of the instantiated
 * object. Also, there is a class variable which counts the number of
 * instantiated objects from that class. The run() method of the class will
 * print the object's name for a number of times equal to the counter's value,
 * each printing being delayed 1000ms.
 */

class MyClass implements Runnable {
    public static int objCount = 0;
    String name;

    MyClass(String name) {
        this.name = name;
        MyClass.objCount++;
    }

    @Override
    public void run() {
        for (int i = 0; i < objCount; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name);
        }
    }
}

public class Lab9_Ex1_FufezanMihai {
    public static void main(String[] args) {
        MyClass class1 = new MyClass("firstclass");
        MyClass class2 = new MyClass("secondclass");
        new Thread(class1).start();
        new Thread(class2).start();
    }
}
