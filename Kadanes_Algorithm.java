/*kadane's Algorithm ->
 * Given an integer array arr[]. Find the contiguous sub-array(containing at least one number) that has the maximum sum and return its sum.
Examples:
Input: arr[] = [1, 2, 3, -2, 5]
Output: 9
Explanation: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.
Input: arr[] = [-1, -2, -3, -4]
Output: -1
Explanation: Max subarray sum is -1 of element (-1)
Input: arr[] = [5, 4, 7]
Output: 16
Explanation: Max subarray sum is 16 of element (5, 4, 7)
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)
Constraints:
1 ≤ arr.size() ≤ 105
-107 ≤ arr[i] ≤ 107
 */

public class Kadanes_Algorithm {
    public static long maxSubarraySum(int[] arr) {
        long maxSoFar = arr[0];
        long currentSum = arr[0];

        // Start iterating from the second element since we have already initialized
        // with the first element
        for (int i = 1; i < arr.length; i++) {
            // Update currentSum: either start a new subarray at arr[i] or continue with the
            // current subarray
            currentSum = Math.max(arr[i], currentSum + arr[i]);

            // Update maxSoFar if currentSum is greater
            maxSoFar = Math.max(maxSoFar, currentSum);
        }

        return maxSoFar; // Return the maximum sum found
    }

    public static void main(String[] args) {
        // Example input array
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        // Call the maxSubarraySum method and store the result
        long maxSum = maxSubarraySum(arr);

        // Print the result
        System.out.println("The maximum subarray sum is: " + maxSum);
    }
}

// Time Complexity = O(n)
// Space Complexity = O(1)