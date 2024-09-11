
/*GFG:FLOOR IN A SORTED ARRAY:
 * 
 * Given a sorted array arr[] of size n without duplicates, and given a value x. Floor of x is defined as the largest element k in arr[] such that k is smaller than or equal to x. Find the index of k(0-based indexing).
Examples
Input: n = 7, x = 0 arr[] = {1,2,8,10,11,12,19}
Output: -1
Explanation: No element less than 0 is found. So output is "-1".
Input: n = 7, x = 5 arr[] = {1,2,8,10,11,12,19}
Output: 1
Explanation: Largest Number less than 5 is 2 (i.e k = 2), whose index is 1(0-based indexing).
Your Task:
The task is to complete the function findFloor() which returns an integer denoting the index value of K or return -1 if there isn't any such number.
Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).
Constraints:
1 ≤ n ≤ 107
1 ≤ arr[i] ≤ 1018
0 ≤ x ≤ arr[n-1]
 */

public class Floor_In_A_Sorted_Array {
    public static int findFloor(long[] arr, int n, long x) {
        int low = 0, high = n - 1;
        int result = -1; // If no floor exists, return -1

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                return mid; // Exact match, the floor is the number itself
            } else if (arr[mid] < x) {
                result = mid; // Update result, as this is the largest so far <= x
                low = mid + 1; // Move to the right half
            } else {
                high = mid - 1; // Move to the left half
            }
        }

        return result; // Index of the largest element <= x
    }

    public static void main(String[] args) {
        long[] arr1 = { 1, 2, 8, 10, 12, 19 };
        long x1 = 5;
        System.out.println("Floor of " + x1 + " is at index: " + findFloor(arr1, arr1.length, x1));
        // Output: Floor of 5 is at index: 1 (element is 2)

        long[] arr2 = { 1, 2, 8, 10, 12, 19 };
        long x2 = 20;
        System.out.println("Floor of " + x2 + " is at index: " + findFloor(arr2, arr2.length, x2));
        // Output: Floor of 20 is at index: 5 (element is 19)

        long[] arr3 = { 1, 2, 8, 10, 12, 19 };
        long x3 = 0;
        System.out.println("Floor of " + x3 + " is at index: " + findFloor(arr3, arr3.length, x3));
        // Output: Floor of 0 is at index: -1 (no floor exists)
    }
}


//! Time Complexity = O(log n)
//! Space Complexity = O(1)