
//GFG:-LONGEST PREFIX SUM

public class Longest_Prefix_Sum {
    public static int lps(String str) {
        int n = str.length();

        // Create LPS (longest prefix suffix) array
        int[] lps = new int[n];

        // Length of previous longest prefix suffix
        int length = 0;

        // lps[0] is always 0
        lps[0] = 0;

        // The loop calculates lps[i] for i = 1 to n-1
        int i = 1;
        while (i < n) {
            if (str.charAt(i) == str.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                // This is tricky. Consider the example "AAACAAAA" and i=7.
                if (length != 0) {
                    length = lps[length - 1];
                    // Don't increment i here
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // The value of lps[n-1] will give the length of the longest prefix suffix
        return lps[n - 1];
    }

    // Main method to test the solution
    public static void main(String[] args) {
        String str = "abab";
        System.out.println("Length of the longest prefix-suffix is: " + lps(str));

        String str2 = "aaaa";
        System.out.println("Length of the longest prefix-suffix is: " + lps(str2));

        // Output will be ->
        /*
         * Length of the longest prefix-suffix is: 2
         * Length of the longest prefix-suffix is: 3
         */
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)