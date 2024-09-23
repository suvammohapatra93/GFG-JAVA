
// GFG:MISSING AND REPEATING:

import java.util.*;

public class Missing_And_Repeating {
    public static int[] findTwoElement(int arr[]) {
        Arrays.sort(arr);
        int rep = 0;
        int lost = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                rep = arr[i];
                break;
            } else {
                continue;
            }
        }

        long n = arr.length;
        long expectedSum = (long) (n * (n + 1)) / 2;
        long actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }
        lost = (int) (expectedSum - (actualSum - rep));

        return new int[] { rep, lost };
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 4 }; // Example input
        int[] result = findTwoElement(arr);
        System.out.println("Repeating: " + result[0] + ", Missing: " + result[1]);

        // Output will be -> Repeating: 2, Missing: 3
    }
}

// ! Time Complexity = O(n log n)
// ! Space Complexity = O(1)