
// GFG:PARANTHESIS CHECKER:

import java.util.Stack;

public class Paranthesis_Checker {
    // Function to check if brackets are balanced or not.
    public static boolean ispar(String x) {
        // Step 1: Create a stack to hold opening brackets
        Stack<Character> stack = new Stack<>();

        // Step 2: Traverse the string character by character
        for (char ch : x.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // If it's a closing bracket, check for the corresponding opening bracket
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If the stack is empty, or the top of the stack doesn't match the current
                // closing bracket, return false
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Step 3: If the stack is empty, the string is balanced
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(ispar("{[()]}")); // Output: true
        System.out.println(ispar("{[(])}")); // Output: false
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)