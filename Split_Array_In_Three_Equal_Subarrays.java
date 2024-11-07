
//GFG -> Split Array In Three Equal Subarrays {

import java.util.ArrayList;
import java.util.List;

public class Split_Array_In_Three_Equal_Subarrays {

    public static List<Integer> findSplit(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        long sum = 0;

        // Calculate the total sum of the array.
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // If the total sum is not divisible by 3, it's impossible to split.
        if (sum % 3 != 0) {
            ans.add(-1);
            ans.add(-1);
        } else {
            long partSum = 0;
            long target = sum / 3;
            int splitCount = 0; // Count of splits found

            // Traverse the array to find the two split points.
            for (int i = 0; i < n; i++) {
                partSum += arr[i];

                // When a third of the total sum is reached, record split point.
                if (partSum == target) {
                    ans.add(i);
                    splitCount++;
                    partSum = 0; // Reset partSum for the next section
                }

                // Stop if two split points are found.
                if (splitCount == 2)
                    break;
            }

            // If less than two splits found, reset result to indicate failure.
            if (splitCount < 2) {
                ans.clear();
                ans.add(-1);
                ans.add(-1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 0, 3 };
        List<Integer> result = findSplit(arr);

        if (result.get(0) == -1) {
            System.out.println("The array cannot be split into 3 equal subarrays.");
        } else {
            System.out.println("The split points are at indices: " + result.get(0) + " and " + result.get(1));
        }
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)