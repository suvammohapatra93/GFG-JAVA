/*GFG:PALINDROME STRING ->
Given a string S, check if it is palindrome or not.
Example 1:
Input: S = "abba"
Output: 1
Explanation: S is a palindrome
Example 2:
Input: S = "abc" 
Output: 0
Explanation: S is not a palindrome
Your Task:
You don't need to read input or print anything. Complete the function isPalindrome()which accepts string S and returns an integer value 1 or 0.
Expected Time Complexity: O(Length of S)
Expected Auxiliary Space: O(1)
Constraints:
1 <= Length of S<= 2*105
*/


public class Palindrome_String{
    public static int isPalindrome(String S) {
        int i=0;
        int j=S.length()-1;
        
        while(i<=j){
            if(S.charAt(i)!=S.charAt(j)){
                return 0;
                
            }
            
            else{
                i++;
                j--;
            }
        }
        
        return 1;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(isPalindrome(s));
    }
};


//! Time Complexity = O(n)
//! Space Complexity = O(1)