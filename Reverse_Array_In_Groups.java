
/*GFG:REVERSE ARRAY IN GROUPS: 
 * 
 * Given an array arr of positive integers. Reverse every sub-array group of size k.
Note: If at any instance, k is greater or equal to the array size, then reverse the entire array. You shouldn't return any array, modify the given array in place.
Examples:
Input: k = 3, arr= [1, 2, 3, 4, 5]
Output: [3, 2, 1, 5, 4]
Explanation: First group consists of elements 1, 2, 3. Second group consists of 4,5.
Input: k = 5, arr = [5, 6, 8, 9]
Output: [9, 8, 6, 5]
Explnation: Since k is greater than array size, the entire array is reversed.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)
Constraints:
1 ≤ arr.size(), k ≤ 107
1 ≤ arr[i] ≤ 1018
*/

import java.util.ArrayList;

public class Reverse_Array_In_Groups {
    void reverseInGroups(ArrayList<Long> arr, int k) {
        int n = arr.size();

        // Traverse the array in groups of size k
        for (int i = 0; i < n; i += k) {
            // Define the start and end of the current group
            int left = i;
            int right = Math.min(i + k - 1, n - 1); // Ensure that we don't go out of bounds

            // Reverse the sub-array from left to right
            while (left < right) {
                // Swap elements at left and right
                long temp = arr.get(left);
                arr.set(left, arr.get(right));
                arr.set(right, temp);

                // Move pointers towards the center
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        Reverse_Array_In_Groups reverser = new Reverse_Array_In_Groups();
        ArrayList<Long> arr = new ArrayList<>();
        arr.add(1L);
        arr.add(2L);
        arr.add(3L);
        arr.add(4L);
        arr.add(5L);

        int k = 3; // Group size

        reverser.reverseInGroups(arr, k);
        System.out.println(arr); // Expected output: [3, 2, 1, 5, 4]
    }

}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)