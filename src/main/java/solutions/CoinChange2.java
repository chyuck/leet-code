package solutions;

/**
 * Solution for https://leetcode.com/problems/coin-change-2/ problem with
 * Time complexity: O(A * C)
 * Space complexity: O(A)
 */
public class CoinChange2 {

    public int change(int amount, int[] coins) {
        int[] results = new int[amount + 1];
        results[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                results[i] += results[i - coin];
            }
        }

        return results[amount];
    }
}
