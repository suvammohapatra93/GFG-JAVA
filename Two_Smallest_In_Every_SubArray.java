
//GFG->TWO SMALLEST IN EVERY SBARRAY ->

public class Two_Smallest_In_Every_SubArray {

    public static int pairWithMaxSum(int[] arr) {
        // If the array has only one element, return -1 as we can't form a pair
        if (arr.length == 1) {
            return -1;
        }

        int maxSum = Integer.MIN_VALUE;

        // Iterate through the array and find the maximum sum of adjacent elements
        for (int i = 0; i < arr.length - 1; i++) {
            int adjacentSum = arr[i] + arr[i + 1];

            if (adjacentSum > maxSum) {
                maxSum = adjacentSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        // Example test cases
        int[] arr1 = { 5, 1, 3, 6, 7 };
        int[] arr2 = { 10, 20, 30, 40, 50 };
        int[] arr3 = { 1 };

        System.out.println(pairWithMaxSum(arr1)); // Output: 13 (6 + 7)
        System.out.println(pairWithMaxSum(arr2)); // Output: 90 (40 + 50)
        System.out.println(pairWithMaxSum(arr3)); // Output: -1 (since only one element)
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)