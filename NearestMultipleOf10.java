
//GFG -> Nearest Multiple of 10 ->

public class NearestMultipleOf10 {
    public static String roundToNearest(String str) {
        int n = str.length(); // Get the length of the string (number)
        StringBuilder sb = new StringBuilder(str); // Use StringBuilder for easier modifications

        // If the last digit is >= 5, we round up
        if (sb.charAt(n - 1) >= '5') {
            sb.setCharAt(n - 1, '0'); // Set the last digit to '0'
            int carryIndex = n - 2; // Start from the second last digit

            // Propagate the carry if needed
            while (carryIndex >= 0 && sb.charAt(carryIndex) == '9') {
                sb.setCharAt(carryIndex, '0'); // Set current digit to '0' if it's '9'
                carryIndex--; // Move to the next left digit
            }

            // If the carryIndex is valid, increase the current digit
            if (carryIndex >= 0) {
                sb.setCharAt(carryIndex, (char) (sb.charAt(carryIndex) + 1)); // Increment the digit
            } else {
                // If we need to add an extra digit (e.g., for 999 -> 1000)
                sb.insert(0, '1');
            }
        } else {
            // If the last digit is < 5, round down by just setting it to '0'
            sb.setCharAt(n - 1, '0');
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        // Example test cases
        String num1 = "1234";
        String num2 = "5679";
        String num3 = "999";
        String num4 = "2500";

        System.out.println("Rounded value of " + num1 + ": " + roundToNearest(num1)); // Output: 1230
        System.out.println("Rounded value of " + num2 + ": " + roundToNearest(num2)); // Output: 5680
        System.out.println("Rounded value of " + num3 + ": " + roundToNearest(num3)); // Output: 1000
        System.out.println("Rounded value of " + num4 + ": " + roundToNearest(num4)); // Output: 2500
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)