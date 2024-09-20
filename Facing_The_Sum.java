
// GFG:FACING THE SUN:

public class Facing_The_Sum {
    public static int countBuildings(int[] height) {
        int maxSoFar = 0;
        int count = 0;

        // Traverse through the array of building heights
        for (int h : height) {
            // A building can see the sun if it's taller than all the previous ones
            if (h > maxSoFar) {
                count++;
                maxSoFar = h;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] height = { 7, 4, 8, 2, 9 };
        System.out.println(countBuildings(height)); // Output: 3

        int[] height2 = { 1, 2, 3, 4, 5 };
        System.out.println(countBuildings(height2)); // Output: 5
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)