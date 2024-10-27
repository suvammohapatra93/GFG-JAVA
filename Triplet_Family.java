
//GFG -> TRIPLET FAMILY

import java.util.*;

public class Triplet_Family {

    public static boolean findTriplet(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                if (left != i && right != i) {
                    int sum = arr[left] + arr[right];

                    if (sum == arr[i])
                        return true;
                    else if (sum < arr[i])
                        left++;
                    else
                        right--;
                } else if (left == i) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 5, 8 };
        boolean result = findTriplet(arr);
        System.out.println("Triplet family exists: " + result);
        // Output -> Triplet family exists: true
    }
}

// ! Time Complexity = O(n^2 log n)
// ! Space Complexity = O(1)