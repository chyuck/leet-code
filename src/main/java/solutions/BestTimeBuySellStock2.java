package solutions;

/**
 * Solution for https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class BestTimeBuySellStock2 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];

            if (profit > 0) {
                result += profit;
            }
        }

        return result;
    }
}
