package solutions;

/**
 * Solution for https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class BestTimeBuySellStock2 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int prev = prices[i-1];
            int curr = prices[i];

            if (curr > prev) {
                maxProfit += curr - prev;
            }
        }

        return maxProfit;
    }
}
