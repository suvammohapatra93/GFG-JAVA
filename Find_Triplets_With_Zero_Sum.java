
// GFG:FIND TRIPLETS WITH 0 SUM:

import java.util.Arrays;

public class Find_Triplets_With_Zero_Sum {
    public static boolean findTriplets(int arr[], int n) {
        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Iterate through the array
        for (int i = 0; i < n - 2; i++) {
            // Use two pointers to find a pair with sum -arr[i]
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    // If the sum is zero, we found the triplet
                    return true;
                } else if (sum < 0) {
                    // If the sum is less than 0, move the left pointer to the right
                    left++;
                } else {
                    // If the sum is greater than 0, move the right pointer to the left
                    right--;
                }
            }
        }

        // If no triplet with zero sum is found, return false
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 0, -1, 2, -3, 1 };
        int n = arr.length;

        boolean result = findTriplets(arr, n);

        // Print the result
        if (result) {
            System.out.println("Triplet with zero sum found.");
        } else {
            System.out.println("No triplet with zero sum found.");
        }

        //Output will be Triplet with zero sum found.
    }
}

// ! Time Complexity = O(n^2)
// ! Space Complexity = O(1)
