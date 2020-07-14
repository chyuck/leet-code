package solutions;

/**
 * Solution for https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class BestTimeBuySellStock3 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int maxProfit1 = 0;
        int minPrice1 = prices[0];

        int maxProfit2 = 0;
        int minPrice2 = prices[0] - maxProfit1;

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];

            maxProfit1 = Math.max(maxProfit1, price - minPrice1);
            minPrice1 = Math.min(minPrice1, price);

            maxProfit2 = Math.max(maxProfit2, price - minPrice2);
            minPrice2 = Math.min(minPrice2, price - maxProfit1);
        }

        return maxProfit2;
    }
}
