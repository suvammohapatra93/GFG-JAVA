
//GFG -> NOT A SUBSET SUM

public class NotASubsetSum {
    public static long findSmallest(int[] arr) {
        long smallestMissing = 1;
        for (int num : arr) {
            if (num > smallestMissing) {
                break;
            }
            smallestMissing = smallestMissing + num;
        }
        return smallestMissing;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 10 };
        System.out.println("The smallest missing number is: " + findSmallest(arr));
        // Output: 7
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)