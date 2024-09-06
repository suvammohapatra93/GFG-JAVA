/*GFG:ROTATE ARRAY:
 * Given an unsorted array arr[] of size n. Rotate the array to the left (counter-clockwise direction) by d steps, where d is a positive integer. 
Note: Consider the array as circular.
Examples :
Input: n = 5, d = 2 arr[] = {1,2,3,4,5}
Output: 3 4 5 1 2
Explanation: 1 2 3 4 5  when rotated by 2 elements, it becomes 3 4 5 1 2.
Input: n = 10, d = 3 arr[] = {2,4,6,8,10,12,14,16,18,20}
Output: 8 10 12 14 16 18 20 2 4 6
Explanation: 2 4 6 8 10 12 14 16 18 20 when rotated by 3 elements, it becomes 8 10 12 14 16 18 20 2 4 6.
Your Task:
You need not print or read anything. You need to complete the function rotateArr() which takes the array, d, and n as input parameters and rotates the array by d elements. The array must be modified in-place without using extra space.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
Constraints:
1 <= n <= 106
1 <= d <= 106
0 <= arr[i] <= 105
 */

public class Rotate_Array {
    public static void rotateArr(int arr[], int d, int n) {
        d = d % n;

        // Step 1: Reverse the first d elements
        reverse(arr, 0, d - 1);

        // Step 2: Reverse the remaining n-d elements
        reverse(arr, d, n - 1);

        // Step 3: Reverse the entire array
        reverse(arr, 0, n - 1);
    }

    // Helper function to reverse a portion of the array
    static void reverse(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Example input array
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

        // Number of positions to rotate
        int d = 2;

        // Size of the array
        int n = arr.length;

        // Rotate the array
        rotateArr(arr, d, n);

        // Print the rotated array
        System.out.print("Rotated array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

// Time Complexity = O(n)
// Space Complexity = O(1)