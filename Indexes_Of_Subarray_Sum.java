
/*GFG:INDEXES OF SUBARRAY SUM */

import java.util.ArrayList;

public class Indexes_Of_Subarray_Sum {
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> ans = new ArrayList<>();
        int start = 0;
        int prefixSum = 0;

        for (int end = 0; end < n; end++) {
            prefixSum += arr[end];

            // Slide the window to ensure the prefix sum does not exceed the target
            while (prefixSum > s && start <= end) {
                prefixSum -= arr[start++];
            }

            // Check if we have found the required sum
            if (prefixSum == s) {
                ans.add(start + 1); // Convert to 1-based index
                ans.add(end + 1);   // Convert to 1-based index
                return ans;
            }
        }

        // If no such subarray exists
        ans.add(-1);
        return ans;
    }

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {1, 2, 3, 7, 5};
        int n1 = arr1.length;
        int s1 = 12;
        System.out.println(subarraySum(arr1, n1, s1)); // Expected output: [2, 4]

        int[] arr2 = {1, 2, 3, 4, 5};
        int n2 = arr2.length;
        int s2 = 15;
        System.out.println(subarraySum(arr2, n2, s2)); // Expected output: [1,5]

        int[] arr3 = {1, 2, 3, 7, 5};
        int n3 = arr3.length;
        int s3 = 15;
        System.out.println(subarraySum(arr3, n3, s3)); // Expected output: [3, 5]
    }
}


//! Time Complexity = O(n)
//! Space Complexity = O(1)