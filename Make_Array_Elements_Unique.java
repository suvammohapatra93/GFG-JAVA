
//GFG -> Make Array Elemenet Unique

import java.util.Arrays;
import java.util.HashSet;

public class Make_Array_Elements_Unique {

    public static int minIncrements(int[] arr) {
        Arrays.sort(arr); // Sort the array
        HashSet<Integer> set = new HashSet<>(); // Set to keep track of unique elements
        int sum = 0; // To store the number of increments required
        int max = 0; // To track the maximum value encountered

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max); // Update max to the larger of current element or previous max

            // If the current element is already in the set, increment it to make it unique
            if (set.contains(arr[i])) {
                sum += max + 1 - arr[i]; // Calculate the number of increments needed
                max++; // Increment max for uniqueness
                set.add(max); // Add the new unique element to the set
            } else {
                set.add(arr[i]); // If element is unique, add it to the set
            }
        }
        return sum; // Return total increments needed
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 1, 2, 1, 7 };
        int result = minIncrements(arr);
        System.out.println("Minimum increments required to make array elements unique: " + result);
    }
}

// ! Time Complexity = O(n log n)
// ! Space Complexity = O(n)