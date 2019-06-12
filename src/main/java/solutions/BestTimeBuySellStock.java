package solutions;

import java.util.HashMap;

/**
* Solution for https://leetcode.com/problems/best-time-to-buy-and-sell-stock problem with
* Time complexity: O(n)
* Space complexity: O(1)
*/
public class BestTimeBuySellStock {

    /**
     * Space complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        // min price
        int minPrice = Integer.MAX_VALUE;
        // max price difference, which will be result
        int maxPriceDiff = 0;

        // iterate through all prices
        for (int i = 0; i < prices.length; i++) {
            // update min price until current price
            minPrice = Math.min(minPrice, prices[i]);
            // update max price difference between current price and min price
            maxPriceDiff = Math.max(maxPriceDiff, prices[i] - minPrice);
        }

        return maxPriceDiff;
    }

    /**
     * Space complexity: O(n)
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        // create max prices hash map: price index -> max price until the end
        final HashMap<Integer, Integer> maxPrices = new HashMap<>();

        // shortcut for the last index
        final int lastIndex = prices.length - 1;

        // add max price for the last index
        maxPrices.put(lastIndex, prices[lastIndex]);

        // calculate all max prices based on next max price
        for (int i = lastIndex - 1; i >= 0; i--) {
            final int maxPrice = Math.max(prices[i], maxPrices.get(i + 1));
            maxPrices.put(i, maxPrice);
        }

        // the highest max difference
        int result = 0;

        // calculate max difference in price for each index and save the highest max difference
        for (int i = 0; i <= lastIndex; i++) {
            final int maxDiff = maxPrices.get(i) - prices[i];
            if (maxDiff > result)
                result = maxDiff;
        }

        return result;
    }
}
