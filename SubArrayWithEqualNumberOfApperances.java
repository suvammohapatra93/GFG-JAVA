
//GFG -> SUBARRAY WITH EQUAL NUMBER OF APPEARANCES

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithEqualNumberOfApperances {

    public static int sameOccurrence(int arr[], int x, int y) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // To handle subarrays that start from the first element
        int fa = 0, fb = 0, ans = 0;

        // Iterate through the array and count occurrences
        for (int i : arr) {
            if (i == x) {
                fa++; // Increase count of x
            } else if (i == y) {
                fb++; // Increase count of y
            }

            // If the difference between the occurrences of x and y has been seen before
            ans += map.getOrDefault(fa - fb, 0);

            // Update the map with the new difference (fa - fb)
            map.merge(fa - fb, 1, Integer::sum);
        }
        return ans; // Return the total number of subarrays with equal occurrences
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 1, 2 };
        int x = 1;
        int y = 2;

        int result = sameOccurrence(arr, x, y);
        System.out.println("The number of subarrays with equal occurrences of " + x + " and " + y + " is: " + result);

        // Output willl be -> The number of subarrays with equal occurrences of 1 and 2
        // is: 4
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)