/*Smallest Positive missing ------------------------->

You are given an array arr[] of N integers. The task is to find the smallest positive number missing from the array.
Note: Positive number starts from 1.
Example 1:
Input:
N = 5
arr[] = {1,2,3,4,5}
Output: 6
Explanation: Smallest positive missing 
number is 6.
Example 2:
Input:
N = 5
arr[] = {0,-10,1,3,-20}
Output: 2
Explanation: Smallest positive missing 
number is 2.
Your Task:
The task is to complete the function missingNumber() which returns the smallest positive missing number in the array.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).
Constraints:
1 <= N <= 106
-106 <= arr[i] <= 106
 */

import java.util.Scanner;

public class Smallest_Positive_Missing {

    public static int missingNumber(int arr[], int size) {
        int n = arr.length;

        // Replace non-positive numbers with a value greater than n
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0) {
                arr[i] = n + 1;
            }
        }

        // Use the array elements to mark the presence of numbers in the range [1, n]
        for (int i = 0; i < n; i++) {
            int num = Math.abs(arr[i]);
            if (num > n) {
                continue;
            } else {
                int index = num - 1;
                if (arr[index] > 0) {
                    arr[index] *= -1;
                }
            }
        }

        // Find the smallest positive missing number
        int res = n + 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                res = i + 1;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the size of the array
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        // Initialize the array
        int[] arr = new int[size];

        // Read the array elements
        System.out.println("Enter the array elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Find the smallest positive missing number
        int result = missingNumber(arr, size);

        // Print the result
        System.out.println("The smallest positive missing number is: " + result);

        sc.close();
    }
}
