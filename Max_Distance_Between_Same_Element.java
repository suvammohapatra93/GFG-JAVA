
//GFG -> MAX DISTANCE BETWEEN SAME ELEMENTS

import java.util.*;

public class Max_Distance_Between_Same_Element {
    public static int maxDistance(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            } else {
                int t = i - map.get(arr[i]);
                max = Math.max(max, t);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 1, 2, 3, 4 };
        int result = maxDistance(arr);
        System.out.println("Maximum distance between identical elements: " + result);
        // Output -> Maximum distance between identical elements: 4
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)