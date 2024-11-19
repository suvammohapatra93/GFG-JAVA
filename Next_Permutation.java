
//GFG -> NEXT PERMUTATION

import java.util.Arrays;

public class Next_Permutation {

    public static void nextPermutation(int[] arr) {
        // Find the first pair from the right where arr[i] < arr[i+1]
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // If no such pair is found, reverse the entire array
        if (i < 0) {
            reverse(arr, 0, arr.length - 1);
            return;
        }

        // Find the smallest number in the right subarray that is greater than arr[i]
        int j = arr.length - 1;
        while (j > i && arr[j] <= arr[i]) {
            j--;
        }

        // Swap arr[i] and arr[j]
        swap(arr, i, j);

        // Reverse the subarray to the right of i
        reverse(arr, i + 1, arr.length - 1);
    }

    // Helper method to reverse a portion of the array
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    // Helper method to swap two elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = { 1, 2, 3 };
        nextPermutation(arr1);
        System.out.println("Next Permutation: " + Arrays.toString(arr1));

        // Test case 2
        int[] arr2 = { 3, 2, 1 };
        nextPermutation(arr2);
        System.out.println("Next Permutation: " + Arrays.toString(arr2));

        // Test case 3
        int[] arr3 = { 1, 1, 5 };
        nextPermutation(arr3);
        System.out.println("Next Permutation: " + Arrays.toString(arr3));

        // Test case 4
        int[] arr4 = { 1 };
        nextPermutation(arr4);
        System.out.println("Next Permutation: " + Arrays.toString(arr4));
    }
}

// ! Time Complexity = O(N)
// ! Space Complexity = O(1)