/*GFG:MISSING IN ARRAY ->
Given an array arr of size n−1 that contains distinct integers in the range of 1 to n (inclusive), find the missing element. The array is a permutation of size n with one element missing. Return the missing element.
Examples:
Input: n = 5, arr[] = [1,2,3,5]
Output: 4
Explanation : All the numbers from 1 to 5 are present except 4.
Input: n = 2, arr[] = [1]
Output: 2
Explanation : All the numbers from 1 to 2 are present except 2.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)
Constraints:
1 ≤ n ≤ 105
1 ≤ arr[i] ≤ n
*/


import java.util.*;
public class Missing_In_Array{
    public static int missingNumber(int n, int arr[]) {

        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=i+1){
                return i+1;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int n = 5;
        int arr[] = {1,2,3,5};
        System.out.println(missingNumber(n, arr));
    }
}

//! Time Complexity = O(n)
//! Space Complexity = O(1)