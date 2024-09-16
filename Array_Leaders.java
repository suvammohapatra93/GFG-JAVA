
// GFG : ARRAY LEADERS:

import java.util.ArrayList;
import java.util.Collections;

public class Array_Leaders {
    static ArrayList<Integer> leaders(int n, int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int maxFromRight = arr[n - 1]; // Rightmost element is always a leader
        result.add(maxFromRight);

        // Traverse the array from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                result.add(arr[i]); // Current element is a leader
                maxFromRight = arr[i]; // Update maxFromRight
            }
        }

        // Reverse the result as we collected leaders from the end
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 16, 17, 4, 3, 5, 2 };
        int n = arr.length;

        ArrayList<Integer> result = Array_Leaders.leaders(n, arr);

        // Print the leaders
        System.out.println("Leaders in the array: " + result);
        // Output will be -> Leaders in the array: [17, 5, 2]
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)