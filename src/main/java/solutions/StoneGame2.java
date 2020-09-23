package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/stone-game-ii/ problem with
 * Time complexity: O(?)
 * Space complexity: O(?)
 */
public class StoneGame2 {

    public int stoneGameII(int[] piles) {
        Map<String, int[]> cache = new HashMap<>();

        int[] stones = takeTurn(0, 1, piles, cache);

        return stones[0];
    }

    private static final int[] ZEROS = new int[] { 0, 0 };

    private static int[] takeTurn(int index, int M, int[] piles, Map<String, int[]> cache) {
        if (index == piles.length) {
            return ZEROS;
        }

        String cacheKey = index + "#" + M;

        int[] cachedResult = cache.get(cacheKey);
        if (cachedResult != null) {
            return cachedResult;
        }

        int[] result = new int[] { 0, 0 };

        int stones = 0;

        int maxPilesToTake = Math.min(2 * M, piles.length - index);
        for (int X = 1; X <= maxPilesToTake; X++) {
            stones += piles[index++];

            int nextM = Math.max(M, X);
            int[] nextStones = takeTurn(index, nextM, piles, cache);

            int totalStones = stones + nextStones[1];
            if (totalStones > result[0]) {
                result[0] = totalStones;
                result[1] = nextStones[0];
            }
        }

        cache.put(cacheKey, result);

        return result;
    }
}
