
// GFG:REVERSE WORDS:

import java.util.*;

public class Reverse_Words {
    // Function to reverse words in a given string.
    public static String reverseWords(String str) {
        // Splitng the string by the dot (.)
        String[] words = str.split("\\.");

        // Reversing the array of words
        Collections.reverse(Arrays.asList(words));

        // Joining the reversed words with dots and return
        return String.join(".", words);
    }

    // Main method to run the solution
    public static void main(String[] args) {
        String input = "i.like.this.program.very.much";
        String result = reverseWords(input);
        System.out.println("Reversed words: " + result);
        // Output will be -> Reversed words: much.very.program.this.like.i
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)