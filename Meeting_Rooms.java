
//GFG -> Meeting Rooms

import java.util.Arrays;

public class Meeting_Rooms {
    static boolean canAttend(int[][] arr) {
        // If there are no meetings, return true
        if (arr == null || arr.length == 0) {
            return true;
        }

        // Sort meetings based on their start times
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // Check for overlaps
        for (int i = 1; i < arr.length; i++) {
            // If the start time of the current meeting is less than the end time of the
            // previous meeting
            if (arr[i][0] < arr[i - 1][1]) {
                return false; // There is an overlap
            }
        }

        // No overlaps found
        return true;
    }

    public static void main(String[] args) {
        int[][] meetings = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println(canAttend(meetings)); // Output: false

        int[][] meetings2 = { { 7, 10 }, { 2, 4 } };
        System.out.println(canAttend(meetings2)); // Output: true
    }
}

// ! Time Complexity = O(n log n)
// ! Space Complexity = O(1)