/*GFG : LARGEST SUBARRAY WITH 0 SUM: --------------->

Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.
Examples:
Input: arr[] = {15,-2,2,-8,1,7,10,23}, n = 8
Output: 5
Explanation: The largest subarray with sum 0 is -2 2 -8 1 7.
Input: arr[] = {2,10,4}, n = 3
Output: 0
Explanation: There is no subarray with 0 sum.
Input: arr[] = {1, 0, -4, 3, 1, 0}, n = 6
Output: 5
Explanation: The subarray is 0 -4 3 1 0.
Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).
Constraints:
1 <= n <= 105
-1000 <= arr[i] <= 1000, for each valid i
 */

import java.util.Scanner;

public class Largest_Subarray_With_0_Sum {
    public static int minJumps(int[] arr) {
        int n = arr.length;

        if (n == 0 || arr[0] == 0) {
            return -1;
        }

        if (n == 1) {
            return 0;
        }

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + arr[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                if (currentEnd >= n - 1) {
                    return jumps;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the size of the array
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        // Initialize the array
        int[] arr = new int[size];

        // Read the array elements
        System.out.println("Enter the array elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Find the minimum number of jumps
        int result = minJumps(arr);

        // Print the result
        System.out.println("The minimum number of jumps required is: " + result);

        sc.close();
    }
}


//! Time Complexity = O(n)
//! Space Complexity = O(1)