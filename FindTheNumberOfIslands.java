
//GFG-> FIND THE NUMBER OF ISLANDS->

import java.util.*;

public class FindTheNumberOfIslands {
    // Directions for moving in 8 directions
    private static final int[][] directions = {
            { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 },
            { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 }
    };

    // Function to find the number of islands.
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int numRows = grid.length; // number of rows in the grid
        int numCols = grid[0].length; // number of columns in the grid
        int islandCount = 0;

        // Iterate through every cell in the grid
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == '1') {
                    islandCount++; // New island found
                    dfsIterative(grid, i, j, numRows, numCols); // Perform DFS iteratively
                }
            }
        }

        return islandCount;
    }

    // Iterative DFS function using a stack to avoid recursion limit issues
    private static void dfsIterative(char[][] grid, int i, int j, int numRows, int numCols) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] { i, j });
        grid[i][j] = '0'; // Mark the cell as visited

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int currRow = current[0];
            int currCol = current[1];

            // Explore all 8 directions
            for (int[] direction : directions) {
                int newRow = currRow + direction[0];
                int newCol = currCol + direction[1];

                // Check if the new cell is valid and is land ('1')
                if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols && grid[newRow][newCol] == '1') {
                    stack.push(new int[] { newRow, newCol });
                    grid[newRow][newCol] = '0'; // Mark it as visited
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '1' },
                { '0', '0', '0', '1', '1' },
                { '0', '0', '0', '0', '0' },
                { '1', '0', '1', '0', '1' }
        };

        int numberOfIslands = numIslands(grid);
        System.out.println("Number of Islands: " + numberOfIslands);
        //Output will be ->  5
    }
}

// ! Time Complexity = O(M * N)
// ! Space Complexity = O(M * N)