
//GFG -> Rotate Array

import java.util.Scanner;

public class Rotate_Array {
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Function to rotate an array by d elements in counter-clockwise direction
    static void rotateArr(int[] arr, int d) {
        int n = arr.length;
        d = d % n; // Handle cases where d > n

        // Reverse the entire array
        reverse(arr, 0, n - 1);

        // Reverse the first n-d elements
        reverse(arr, 0, n - d - 1);

        // Reverse the last d elements
        reverse(arr, n - d, n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take array input
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Take rotation steps
        System.out.print("Enter the number of steps to rotate: ");
        int d = scanner.nextInt();

        // Rotate the array
        rotateArr(arr, d);

        // Print the rotated array
        System.out.println("Rotated array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}