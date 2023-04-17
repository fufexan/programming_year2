/*
 * 1. Write a class named Methods having 3 methods: a method with a variable
 * number of integer parameters, which returns the arithmetic mean of the
 * parameters; another method in which will be defined a one-dimensional array
 * of n double-type numbers (n being the parameter of the method and which will
 * be read in main() from the keyboard), its elements will receive randomly
 * generated values and the method will return this array; a static method that
 * receives as a parameter a character array, converts the respective characters
 * into uppercase letters and forms a String object from this array, which will
 * be returned by the function. From the main() method, defined in another
 * class, call the methods of the Methods class and display the results on the
 * screen (the call values for the first method and the character string for the
 * 3rd method will be defined in main ()).
 */

import java.util.Arrays;
import java.util.Random;

class MethodsMain {
    public static void main(String[] args) {
        System.out.println(Methods.arithmeticMean(3,6,0,1,5,7,2,9,6,4,2,8));
        System.out.println(Arrays.toString(Methods.randomArray(5)));
        System.out.println(Methods.charsToString(new char[]{'b', 'o', 'o', 'm'}));
    }
}

public class Methods {
    static int arithmeticMean(int... args) {
        int sum = 0;
        for (int i : args) {
            sum += i;
        }
        return sum / args.length;
    }

    static int[] randomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt();
        }

        return arr;
    }

    static String charsToString(char[] chars) {
        return String.copyValueOf(chars).toUpperCase();
    }
}