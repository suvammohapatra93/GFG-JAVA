/*GFG: NTH NATURAL NUMBER --------------->

Given a positive integer n. You have to find nth natural number after removing all the numbers containing the digit 9.
Examples :
Input: n = 8
Output: 8
Explanation: After removing natural numbers which contains digit 9, first 8 numbers are 1,2,3,4,5,6,7,8 and 8th number is 8.
Input: n = 9
Output: 10
Explanation: After removing natural numbers which contains digit 9, first 9 numbers are 1,2,3,4,5,6,7,8,10 and 9th number is 10.
Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(1)
Constraints:
1 ≤ n ≤ 109
 */

import java.util.*;

public class Nth_Natural_Number {
    public static long findNth(long n) {
        long res = 0;
        long p = 1;
        while (n > 0) {
            res += (n % 9) * p;
            n /= 9;
            p *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the input number n
        System.out.print("Enter the value of n: ");
        long n = sc.nextLong();

        // Find the nth natural number
        long result = findNth(n);

        // Print the result
        System.out.println("The " + n + "th natural number in the sequence is: " + result);

        sc.close();
    }
}


//! Time Complexity = O(log n)
//! Space Complexity = O(1)