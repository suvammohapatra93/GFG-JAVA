
/* NTH FIBONACCI NUMBER ->
 * 
 * Given a positive integer n, find the nth fibonacci number. Since the answer can be very large, return the answer modulo 1000000007.

Note: for the reference of this question take first fibonacci number to be 1.
Examples :
Input: n = 2
Output: 1 
Explanation: 1 is the 2nd number of fibonacci series.
Input: n = 5
Output: 5
Explanation: 5 is the 5th number of fibonacci series.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)
Constraints:
1<= n <=10^5
 */


import java.util.*;
public class Nth_Fibonacci_Number {
    public static int nthFibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int a = 0, b = 1, c;
        int mod = 1000000007;
        // Calculate Fibonacci up to the nth number
        for (int i = 2; i <= n; i++) {
            c = (a + b) % mod;
            a = b;
            b = c;
        }

        return b; // R
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n:");
        int n = sc.nextInt();
        System.out.println("The " + n + "th Fibonacci number is: " + nthFibonacci(n));
    }
}



//! Time Complexity = O(n)
//! Space Complexity = O(1)