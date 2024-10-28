
//GFG -> Remove duplicate in array

import java.util.*;

public class Remove_Duplicate_In_Array {
    static ArrayList<Integer> removeDuplicate(int arr[]) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!array.contains(arr[i])) {
                array.add(arr[i]);
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 2, 4, 1, 5 };

        ArrayList<Integer> result = removeDuplicate(arr);

        System.out.println("Array after removing duplicates: " + result);
        // Output -> Array after removing duplicates: [1, 2, 3, 4, 5]
    }
}