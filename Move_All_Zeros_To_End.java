
//GFG -> MOVE ALL ZEROS TO END

import java.util.Arrays;

public class Move_All_Zeros_To_End {

    // Method to move all zeros to the end of the array
    public static void pushZerosToEnd(int[] arr) {
        int start = 0;
        int arrLen = arr.length;

        // Move non-zero elements to the front
        for (int i = 0; i < arrLen; i++) {
            if (arr[i] != 0) {
                arr[start] = arr[i];
                start++;
            }
        }

        // Fill the rest of the array with zeros
        for (int i = start; i < arrLen; i++) {
            arr[start] = 0;
            start++;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9 };
        System.out.println("Original array: " + Arrays.toString(arr1));
        pushZerosToEnd(arr1);
        System.out.println("Modified array: " + Arrays.toString(arr1));

        int[] arr2 = { 1, 2, 3, 0, 0, 0 };
        System.out.println("Original array: " + Arrays.toString(arr2));
        pushZerosToEnd(arr2);
        System.out.println("Modified array: " + Arrays.toString(arr2));

        int[] arr3 = { 0, 0, 0, 4, 5, 6 };
        System.out.println("Original array: " + Arrays.toString(arr3));
        pushZerosToEnd(arr3);
        System.out.println("Modified array: " + Arrays.toString(arr3));
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)