
//GFG -> ROTATE AND DELETE

import java.util.*;

public class Rotate_And_Delete {
    public static int rotateDelete(ArrayList<Integer> arr) {
        int n = arr.size();
        int k = 1;
        while (n > 1) {
            Collections.rotate(arr, 1);
            int idx = n - k;
            if (idx < 0) {
                idx = 0;
            }
            arr.remove(idx);
            --n;
            ++k;
        }
        return arr.get(0);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(rotateDelete(arr)); // Output: 3
    }
}

// ! Time Complexity = O(n^2)
// ! Space Complexity = O(1)