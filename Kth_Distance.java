
//GFG -> Kth Distance

import java.util.HashSet;

public class Kth_Distance {

    public static boolean containsDuplicateWithinKDistance(int[] arr, int k) {
        // Create a HashSet to keep track of elements within the current window
        HashSet<Integer> hst = new HashSet<>();

        // Initialize the HashSet with the first (k+1) elements
        for (int i = 0; i < k + 1 && i < arr.length; i++) {
            // If the element is already in the HashSet, a duplicate within distance k is
            // found
            if (hst.contains(arr[i])) {
                return true;
            }
            hst.add(arr[i]);
        }

        // Use sliding window technique
        int i = 0, j = k + 1;
        while (j < arr.length) {
            // Remove the element going out of the window
            hst.remove(arr[i]);

            // Check if there's a duplicate for the new element being added
            if (hst.contains(arr[j])) {
                return true;
            }
            // Add the new element into the window
            hst.add(arr[j]);

            // Move the window
            i++;
            j++;
        }

        // If no duplicates were found within distance k, return false
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 4, 5 };
        int k = 3;
        System.out.println(containsDuplicateWithinKDistance(arr, k)); // Expected output: true
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(k)