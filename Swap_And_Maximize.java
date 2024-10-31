
//GFG -> Swap And Maximize

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Swap_And_Maximize {
    public static long maxSum(Long[] arr) {
        // Sort the array to easily pick min and max values in order
        Arrays.sort(arr);

        // Use a list to arrange elements to maximize the sum of differences
        ArrayList<Long> arrangedList = new ArrayList<>();
        int n = arr.length;

        // Place elements alternately from the smallest and largest ends
        for (int i = 0; i < n / 2; i++) {
            arrangedList.add(arr[i]); // Smallest element
            arrangedList.add(arr[n - 1 - i]); // Largest element
        }

        // If the array has an odd length, add the middle element at the end
        if (n % 2 != 0) {
            arrangedList.add(arr[n / 2]);
        }

        // Calculate the maximum sum of absolute differences
        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += Math.abs(arrangedList.get(i) - arrangedList.get(i + 1));
        }

        // Add the difference between the last and first element to close the loop
        sum += Math.abs(arrangedList.get(n - 1) - arrangedList.get(0));

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Long[] arr = new Long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }

            long result = maxSum(arr);
            System.out.println(result);
        }

        sc.close();
    }
}

// ! Time Complexity = O(n log n)
// ! Space Complexity = O(n)