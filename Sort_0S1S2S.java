/*Sort 0S 1S 2S ->
 * 
 * Given an array arr containing only 0s, 1s, and 2s. Sort the array in ascending order.
Examples:
Input: arr[]= [0, 2, 1, 2, 0]
Output: 0 0 1 2 2
Explanation: 0s 1s and 2s are segregated into ascending order.
Input: arr[] = [0, 1, 0]
Output: 0 0 1
Explanation: 0s 1s and 2s are segregated into ascending order.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)
Constraints:
1 <= arr.size() <= 106
0 <= arr[i] <= 2
 */

import java.util.ArrayList;

public class Sort_0S1S2S {
    public void sort012(ArrayList<Integer> arr) {
        int low = 0;
        int mid = 0;
        int high = arr.size() - 1;

        // Traverse the array
        while (mid <= high) {
            switch (arr.get(mid)) {
                case 0:
                    // Swap arr[low] and arr[mid]
                    int temp0 = arr.get(low);
                    arr.set(low, arr.get(mid));
                    arr.set(mid, temp0);
                    low++;
                    mid++;
                    break;

                case 1:
                    // If the element is 1, just move mid pointer
                    mid++;
                    break;

                case 2:
                    // Swap arr[mid] and arr[high]
                    int temp2 = arr.get(mid);
                    arr.set(mid, arr.get(high));
                    arr.set(high, temp2);
                    high--;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Sort_0S1S2S sorter = new Sort_0S1S2S();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(1);
        arr.add(0);
        arr.add(2);

        sorter.sort012(arr);
        System.out.println(arr); // Expected output: [0, 0, 1, 1, 2, 2]
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)