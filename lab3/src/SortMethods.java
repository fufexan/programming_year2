/*
 * 5. Implement the already known sorting algorithms (bubble sort, insertion
 * sort, quick sort, etc.) and apply them upon an array of integer variables
 * read from the keyboard.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortMethods {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a list of integer values. Press enter when you're done:");
        String[] val = in.nextLine().split(" ");
        ArrayList<Integer> ints = new ArrayList<>();
        ArrayList<Integer> sorted;

        for (String i : val) {
            ints.add(Integer.valueOf(i));
        }

        // test each sort
        System.out.println("Sorting using bubble sort:");
        sorted = bubbleSort(ints);
        for (int i : sorted) {
            System.out.printf("%d ", i);
        }
        System.out.print("\n\n");

        System.out.println("Sorting using insertion sort:");
        sorted = insertionSort(ints);
        for (int i : sorted) {
            System.out.printf("%d ", i);
        }
        System.out.print("\n\n");

        System.out.println("Sorting using quick sort:");
        sorted = quickSort(ints, ints.get(0), ints.size() - 1);
        for (int i : sorted) {
            System.out.printf("%d ", i);
        }
        System.out.print("\n\n");
    }

    /**
     * @param list list to sort
     * @return sorted list using bubble sort
     */
    private static ArrayList<Integer> bubbleSort(ArrayList<Integer> list) {
        boolean sorted;
        do {
            sorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    Collections.swap(list, i, i + 1);
                    sorted = false;
                }
            }
        } while (!sorted);
        return list;
    }

    /**
     * @param list list to sort
     * @return sorted list using insertion sort
     */
    private static ArrayList<Integer> insertionSort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i; j > 0 && list.get(j - 1) > list.get(j); j--) {
                Collections.swap(list, j - 1, j);
            }
        }
        return list;
    }

    /**
     * @param list list to sort
     * @param l    left boundary
     * @param r    right boundary
     * @return list sorted using quicksort
     */
    private static ArrayList<Integer> quickSort(ArrayList<Integer> list, int l, int r) {
        int i = l;
        int j = r;
        int pivot = list.get(j);

        do {
            while (list.get(i) < pivot)
                i++;
            while (list.get(j) > pivot)
                j--;
            if (i < j)
                Collections.swap(list, i, j);
            if (i <= j) {
                j--;
                i++;
            }
        } while (i < j);

        if (l < j)
            list = quickSort(list, l, j);
        if (i < r)
            list = quickSort(list, i, r);

        return list;
    }

//    private static ArrayList<Integer> mergeSort(ArrayList<Integer> list)
}
