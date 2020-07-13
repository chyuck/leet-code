package solutions;

import java.util.HashMap;

/**
* Solution for https://leetcode.com/problems/best-time-to-buy-and-sell-stock problem with
* Time complexity: O(n)
* Space complexity: O(1)
*/
public class BestTimeBuySellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1 ; i < prices.length; i++) {
            int price = prices[i];

            maxProfit = Math.max(maxProfit, price - minPrice);

            minPrice = Math.min(minPrice, price);
        }

        return maxProfit;
    }
}
