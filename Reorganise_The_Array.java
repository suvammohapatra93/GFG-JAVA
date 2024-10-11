
//GFG-> REORGANISE THE ARRAY ->

import java.util.ArrayList;
import java.util.List;

class Reorganise_The_Array {
    public static List<Integer> rearrange(List<Integer> arr) {
        int n = arr.size();
        List<Integer> result = new ArrayList<>();

        // Initialize the result list with -1
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }

        // Iterate through the input list and set the correct values
        for (int i = 0; i < n; i++) {
            if (arr.get(i) >= 0 && arr.get(i) < n) {
                result.set(arr.get(i), arr.get(i));
                // Place the element at its index
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(-1);
        arr.add(-1);
        arr.add(6);
        arr.add(1);
        arr.add(9);
        arr.add(3);
        arr.add(7);
        arr.add(-1);
        arr.add(8);
        arr.add(-1);

        List<Integer> result = rearrange(arr);

        System.out.println("Rearranged array:");
        for (int num : result) {
            System.out.print(num + " ");
        }

        // Output -> Rearranged array: -1 1 -1 3 -1 -1 6 7 8 9
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(n)