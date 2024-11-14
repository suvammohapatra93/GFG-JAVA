
//GFG -> Nearly Sorted

import java.util.PriorityQueue;
import java.util.Arrays;

public class NearlySorted {

    public void nearlySorted(int[] arr, int k) {
        // Priority queue to store elements up to k-distance sorted
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int i = 0;

        // Add elements to the priority queue and remove the smallest to maintain order
        for (int ele : arr) {
            queue.offer(ele);
            if (queue.size() > k) {
                arr[i++] = queue.poll();
            }
        }

        // Place remaining elements in the array
        while (!queue.isEmpty()) {
            arr[i++] = queue.poll();
        }
    }

    public static void main(String[] args) {
        NearlySorted solution = new NearlySorted();

        int[] arr = { 6, 5, 3, 2, 8, 10, 9 };
        int k = 3;

        System.out.println("Original array: " + Arrays.toString(arr));

        solution.nearlySorted(arr, k);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}

// ! Time Complexity = O(n log k)
// ! Space Complexity = O(k)