
/*GFG:ANAGRAM: */

import java.util.Arrays;

public class Anagram {
    public static boolean isAnagram(String a, String b) {
        // Check if lengths are different
        if (a.length() != b.length()) {
            return false;
        }

        // Convert strings to char arrays and sort them
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        // Compare sorted arrays
        return Arrays.equals(arrayA, arrayB);
    }

    public static void main(String[] args) {
        String a = "listen";
        String b = "silent";

        if (isAnagram(a, b)) {
            System.out.println(a + " and " + b + " are anagrams.");
        } else {
            System.out.println(a + " and " + b + " are not anagrams.");
        }
    }
}

//! Time Complexity = O(n log n)
//! Space Complexity = O(1)
