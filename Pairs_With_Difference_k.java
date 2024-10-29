
//GFG -> PAIRS WITH DIFDFERENCE

import java.util.Arrays;

public class Pairs_With_Difference_k {
    public static int countPairsWithDiffK(int[] arr, int k) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[i] - arr[j] == k) {
                    count++;
                } else if (arr[i] - arr[j] < k) {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 3, 4, 2 };
        int k = 3;
        int result = countPairsWithDiffK(arr, k);
        System.out.println("Number of pairs with difference " + k + ": " + result);
        // Output -> 2
    }
}

// ! Time Complexity = O(n^2)
// ! Space Complexity = O(1)