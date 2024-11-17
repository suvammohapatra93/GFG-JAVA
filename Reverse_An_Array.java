
//GFG -> Reverse An array

import java.util.Arrays;

public class Reverse_An_Array {

    public static void reverseArray(int[] arr) {
        if (arr.length >= 1) {
            for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = { 1, 2, 3, 4, 5 };
        System.out.println("Original array: " + Arrays.toString(arr1));
        reverseArray(arr1);
        System.out.println("Reversed array: " + Arrays.toString(arr1));
        // Expected output: [5, 4, 3, 2, 1]

        // Test case 2
        int[] arr2 = { 10, 20, 30 };
        System.out.println("Original array: " + Arrays.toString(arr2));
        reverseArray(arr2);
        System.out.println("Reversed array: " + Arrays.toString(arr2));
        // Expected output: [30, 20, 10]

        // Test case 3
        int[] arr3 = { 42 };
        System.out.println("Original array: " + Arrays.toString(arr3));
        reverseArray(arr3);
        System.out.println("Reversed array: " + Arrays.toString(arr3));
        // Expected output: [42]

        // Test case 4
        int[] arr4 = {};
        System.out.println("Original array: " + Arrays.toString(arr4));
        reverseArray(arr4);
        System.out.println("Reversed array: " + Arrays.toString(arr4));
        // Expected output: []
    }
}

// ! Time Complexity = O(N)
// ! Space Complexity = O(1)