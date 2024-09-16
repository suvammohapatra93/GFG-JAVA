
// GFG:LONGEST VALID PARANTHESIS

import java.util.Stack;

public class Longest_Valid_Paranthesis {
    public static int maxLength(String S) {
        // Stack to store the indices of the parentheses
        Stack<Integer> stack = new Stack<>();

        // Initialize the base of valid parentheses (acts as a boundary for the last
        // valid position)
        stack.push(-1);

        int maxLen = 0;

        // Traverse the string character by character
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            // If we encounter an opening parenthesis, push its index to the stack
            if (c == '(') {
                stack.push(i);
            }
            // If we encounter a closing parenthesis
            else {
                stack.pop();

                // If the stack is empty, push the current index as the new base
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // Calculate the length of the current valid substring
                    int len = i - stack.peek();
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String S = "(()))())(";

        int result = Longest_Valid_Paranthesis.maxLength(S);

        // Print the result
        System.out.println("The length of the longest valid parentheses substring is: " + result);
        //Output will be -> The length of the longest valid parentheses substring is: 4
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)