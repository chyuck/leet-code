package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solutions for https://leetcode.com/problems/coin-change problem with
 * Time complexity: O(S * n)
 * Space complexity: O(S)
 * where S - amount, n - number of coins
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        Map<Integer, Integer> cache = new HashMap<>();

        return coinChange(coins, amount, cache);
    }

    private int coinChange(int[] coins, int amount, Map<Integer, Integer> cache) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        Integer cachedAmount = cache.get(amount);
        if (cachedAmount != null) {
            return cachedAmount;
        }

        int result = -1;

        for (int coin : coins) {
            int amountWithoutCoin = amount - coin;
            int coinChange = coinChange(coins, amountWithoutCoin, cache);
            if (coinChange == -1) {
                continue;
            }

            result = result == -1 ? coinChange + 1 : Math.min(result, coinChange + 1);
        }

        cache.put(amount, result);

        return result;
    }
}
