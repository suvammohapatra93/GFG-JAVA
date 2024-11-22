
//GFG -> Stock Buy And Sell Max One Transaction Allowed

public class Stock_Buy_And_Sell_Max_One_transaction_Allowed {

    public static int maximumProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 0; i < n; i++) {
            // Update minimum price if a lower price is found
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // Calculate profit and update maximum profit if it's higher
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };

        System.out.println("Maximum Profit: " + maximumProfit(prices));
    }
}

// ! Time Complexity = O(n)
// ! Space Complexity = O(1)