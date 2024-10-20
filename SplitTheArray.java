
//GFG -> SPLIT THE ARRAY 

import java.util.Scanner;

public class SplitTheArray {

    public static int countgroup(int arr[]) {
        int totalXOR = 0;

        // XOR of all elements in the array
        for (int x : arr) {
            totalXOR ^= x;
        }

        // If the total XOR of the array is not zero, we cannot split it into
        // two equal XOR parts.
        if (totalXOR != 0) {
            return 0;
        }

        int count = 0;
        int prefixXOR = 0;

        // We count the number of places where we can split the array such that
        // the XOR of the two parts is the same.
        for (int i = 0; i < arr.length - 1; i++) {
            prefixXOR ^= arr[i];
            // If the prefix XOR is equal to totalXOR (which is 0), it means we
            // can potentially split the array here.
            if (prefixXOR == totalXOR) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = countgroup(arr);
        System.out.println("Number of possible ways to split the array: " + result);

        sc.close();
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)