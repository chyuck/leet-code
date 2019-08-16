package solutions;

/**
 * Solutions for https://leetcode.com/problems/coin-change problem with
 * Time complexity: O(S * n)
 * Space complexity: O(S)
 * where S - amount, n - number of coins
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        // if amount is zero, then we need zero coins
        if (amount == 0)
            return 0;
        // if no coins given, then no solution
        if (coins.length == 0)
            return -1;

        // create dynamic programming cache
        int[] cache = new int[amount];

        return coinChange(coins, amount, cache);
    }

    private int coinChange(int[] coins, int amount, int[] cache) {
        // if cache has solution return it
        if (cache[amount - 1] != 0)
            return cache[amount - 1];

        // set result as impossible min value, to see whether better solution is found at the end
        int result = amount + 1;

        // iterate through all coins
        for (int coin : coins) {
            // if amount is equal to coin, then return 1 coin
            // add solution to cache
            if (coin == amount) {
                cache[amount - 1] = 1;
                return 1;
            }

            // if coin is greater than amount, then skip this coin
            if (coin > amount)
                continue;

            // calculate sub result for amount without current coin
            int subResult = coinChange(coins, amount - coin, cache);
            // if no solution for amount without current coin, then skip this coin
            if (subResult <= 0)
                continue;

            // calculate minimum result based on sub result for amount without current coin plus this coin
            result = Math.min(result, subResult + 1);
        }

        // if result still has impossible min value, then no solution found for current amount
        // return -1 and add result to cache
        if (result == amount + 1) {
            cache[amount - 1] = -1;
            return -1;
        }

        // add result to cache and return it
        cache[amount - 1] = result;
        return result;
    }
}
