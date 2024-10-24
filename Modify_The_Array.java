
// GFG -> MODIFY THE ARRAY ->


import java.util.*;

public class Modify_The_Array{
    public static ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
         for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != 0 && arr[i] == arr[i + 1]) {
                arr[i] *= 2;
                arr[i + 1] = 0;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int num : arr) {
            if (num != 0) {
                result.add(num);
            }
        }

        while (result.size() < arr.length) {
            result.add(0);
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = {2, 2, 0, 4, 4, 8};
        ArrayList<Integer> result = modifyAndRearrangeArr(arr);
        System.out.println("Modified array: " + result);
    }
}

//! Time Complexity = O(n)
//! Space Complexity = O(n)