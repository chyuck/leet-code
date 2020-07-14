package solutions;

/**
 * Solution for https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/ problem with
 * Time complexity: O(n * k)
 * Space complexity: O(k)
 */
public class BestTimeBuySellStock4 {

    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices == null || prices.length <= 1) {
            return 0;
        }

        boolean unlimitedTransactions = k * 2 >= prices.length;

        return unlimitedTransactions
            ? maxProfitForUnlimitedTransactions(prices)
            : maxProfitForAtMostKTransactions(k, prices);
    }

    private static int maxProfitForUnlimitedTransactions(int[] prices) {
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];

            if (profit > 0) {
                result += profit;
            }
        }

        return result;
    }

    private static int maxProfitForAtMostKTransactions(int k, int[] prices) {
        int[] minPrices = new int[k];
        for (int i = 0; i < minPrices.length; i++) {
            minPrices[i] = prices[0];
        }

        int[] maxProfit = new int[k];

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];

            maxProfit[0] = Math.max(maxProfit[0], price - minPrices[0]);
            minPrices[0] = Math.min(minPrices[0], price);

            for (int j = 1; j < k; j++) {
                maxProfit[j] = Math.max(maxProfit[j], price - minPrices[j]);
                minPrices[j] = Math.min(minPrices[j], price - maxProfit[j - 1]);
            }
        }

        return maxProfit[k - 1];
    }
}
