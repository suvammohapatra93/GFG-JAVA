
//GFG -> ALternative Sorting

import java.util.*;

public class Alternative_Sorting {
    public static ArrayList<Integer> alternateSort(int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> a = new ArrayList<Integer>();
        int last = arr.length - 1;
        int first = 0;

        while (first <= last) {
            if (first != last) {
                a.add(arr[last--]);
                a.add(arr[first++]);
            } else {
                a.add(arr[first++]);
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 1, 4, 2, 3, 6 };
        ArrayList<Integer> result = alternateSort(arr);
        System.out.println(result);
        // Output -> [7, 1, 6, 2, 4, 3]
    }
}

//! Time Complexity = O(n)
//! Space Complexity = O(1)