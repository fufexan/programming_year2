/*
 * 3. Define a package that declares an interface named Int1 (2 integer
 * variables and a sum() method that returns the sum of 2 integer values).
 * Include in the same package a class named Class1 (2 protected double
 * variables, constructor, setters and getters). In another source file,
 * add in the same package a new interface named Int2 (2 double variables and
 * a method named product() that returns the product of 2 double values).
 * Implement a distinct source file and import everything from the defined
 * package. Define a class named Class2 that is derived from Class1 and
 * implements both interfaces Int1 and Int2. Instantiate Class2 and call the
 * defined methods for determining the sum and product of some values read from
 * the keyboard.
 */

package mypackage;

public interface Int1 {
    int a = 0, b = 0;

    int sum(int a, int b);
}


