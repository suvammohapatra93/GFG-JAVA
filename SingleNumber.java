
//GFG -> Single Number 

public class SingleNumber {
    public static int getSingle(int arr[]) {
        int res = 0;

        // XOR all elements, duplicates will cancel out
        for (int n : arr) {
            res ^= n;
        }

        return res; // The result will be the single number
    }

    public static void main(String[] args) {
        // Example array input where every number appears twice except one
        int[] arr = { 2, 3, 5, 4, 5, 3, 4 };

        // Calling the method and printing the result
        System.out.println("The single number is: " + getSingle(arr));
        // Output: 2
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)