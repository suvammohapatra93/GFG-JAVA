
//GFG-> LARGEST PAIR SUM ->

public class Largest_Pair_Sum {
    public static int pairSum(int[] arr) {
        int a = 0, b = 0;
        for (int i : arr) {
            if (i > a) {
                b = a;
                a = i;
            } else if (i > b)
                b = i;
        }
        return a + b;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 1, 8, 2, 7 };

        int result = pairSum(arr);

        System.out.println("The sum of the two largest distinct elements is: " + result);
        // Output -> The sum of the two largest distinct elements is: 15
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)