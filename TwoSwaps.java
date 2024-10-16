
// GFG -> Two Swaps ->

import java.util.*;

public class TwoSwaps {

    public static boolean checkSorted(List<Integer> arr) {
        int count = 0;

        // Loop through the array to check and swap elements
        for (int i = 0; i < arr.size(); i++) {
            while (arr.get(i) != i + 1) {
                int num = arr.get(i) - 1;

                // Swap the current element with the correct one
                int temp = arr.get(num);
                arr.set(num, arr.get(i));
                arr.set(i, temp);
                count++;

                // If more than two swaps are needed, return false
                if (count > 2) {
                    return false;
                }
            }
        }
        // Return true only if no swaps or exactly two swaps were needed
        return count == 0 || count == 2;
    }

    public static void main(String[] args) {
        // Example test cases
        List<Integer> arr1 = Arrays.asList(3, 1, 2);
        List<Integer> arr2 = Arrays.asList(1, 2, 3);
        List<Integer> arr3 = Arrays.asList(4, 3, 2, 1);

        // Testing the checkSorted method
        System.out.println(checkSorted(arr1)); // Output: true (requires two swaps)
        System.out.println(checkSorted(arr2)); // Output: true (already sorted)
        System.out.println(checkSorted(arr3)); // Output: false (requires more than two swaps)
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)