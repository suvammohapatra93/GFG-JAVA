
// GFG -> STOCKS BUY AND SELL MULTIPLE TRANSACTION ALLOWED

import java.util.Arrays;

public class Stocks_Buy_And_Sell_Multiple_Transaction_Allowed {

    public static int maximumProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2]; // dp[i][0] -> not holding stock, dp[i][1] -> holding stock
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return f(0, 0, n, prices, dp); // Start with the first day and "not holding" state
    }

    private static int f(int i, int flag, int n, int[] prices, int[][] dp) {
        if (i == n) { // Base case: no days left
            return 0;
        }
        if (dp[i][flag] != -1)
            return dp[i][flag]; // Use memoized result

        int profit = f(i + 1, flag, n, prices, dp); // Skip the current day

        if (flag == 0) { // Not holding stock
            profit = Math.max(profit, -prices[i] + f(i + 1, 1, n, prices, dp)); // Buy stock
        } else { // Holding stock
            profit = Math.max(profit, prices[i] + f(i + 1, 0, n, prices, dp)); // Sell stock
        }

        return dp[i][flag] = profit; // Memoize and return
    }

    public static void main(String[] args) {
        // Test case 1
        int[] prices1 = { 7, 1, 5, 3, 6, 4 };
        System.out.println("Maximum Profit: " + maximumProfit(prices1)); // Expected: 7

        // Test case 2
        int[] prices2 = { 1, 2, 3, 4, 5 };
        System.out.println("Maximum Profit: " + maximumProfit(prices2)); // Expected: 4

        // Test case 3
        int[] prices3 = { 7, 6, 4, 3, 1 };
        System.out.println("Maximum Profit: " + maximumProfit(prices3)); // Expected: 0
    }
}

// ! Time Complexity = O(N)
// ! Space Complexity = O(N)