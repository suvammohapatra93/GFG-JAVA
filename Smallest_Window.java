
//GFG:Smallest_Window_In_A_String_Containing_All_The_Characters_Of_Another_Strings  -

public class Smallest_Window {
    public static String smallestWindow(String s, String p) {
        // Step 1: Frequency count of characters in p
        int[] pFreq = new int[128]; // ASCII size
        for (char ch : p.toCharArray()) {
            pFreq[ch]++;
        }

        // Step 2: Initialize variables
        int[] sFreq = new int[128];
        int minLen = Integer.MAX_VALUE; // To store the smallest window size
        int start = 0; // Starting index of the smallest window
        int count = 0; // To count the matching characters
        int left = 0; // Left pointer of the window

        // Step 3: Sliding window
        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);
            sFreq[rChar]++;

            // If the current character of s is in p and its frequency in the window is <=
            // its frequency in p
            if (pFreq[rChar] != 0 && sFreq[rChar] <= pFreq[rChar]) {
                count++;
            }

            // Step 4: When all characters of p are matched in the current window
            while (count == p.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Try to reduce the window size from the left
                char lChar = s.charAt(left);
                sFreq[lChar]--;

                // If the character frequency goes below the required count, decrement the match
                // count
                if (pFreq[lChar] != 0 && sFreq[lChar] < pFreq[lChar]) {
                    count--;
                }
                left++;
            }
        }

        // Step 5: If no valid window is found, return "-1"
        return minLen == Integer.MAX_VALUE ? "-1" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String p = "ABC";
        System.out.println(smallestWindow(s, p));
        // Output: "BANC"
    }
}