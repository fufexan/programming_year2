/*
 * Lab 6, Fufezan Mihai, ex 4
 * 4. Write a Java class derived from the Exception class, called
 * SuperException. Another class, called SmallerException is derived from
 * SuperException. Within the classes' constructors print a message which
 * indicates which exception was generated. In a third class create a method
 * a() which throws an exception of type SmallerException, and a method b()
 * which throws a SuperException. In the main() method call these two methods
 * and try to determine the type of exception which occurs, as well as if the
 * corresponding catch block for the SmallerException can catch a SuperException.
 */

public class SuperException extends Exception {
    SuperException() {
        System.out.println("Generated SuperException");
    }
}

class SmallerException extends SuperException {
    SmallerException() {
        System.out.println("Generated SmallerException");
    }
}

class ExceptionThrower {
    static void a() throws SmallerException {
        throw new SmallerException();
    }
    static void b() throws SuperException {
        throw new SuperException();
    }

    public static void main(String[] args) {
        try {
            a();
        } catch (SmallerException se) {
            System.out.println("SmallerException caught!");
        }

        try {
            b();
//        } catch (SmallerException se) {
        } catch (SuperException se) {
            System.out.println("SuperException cannot be caught with a SmallerException catch block!");
        }
    }
}
