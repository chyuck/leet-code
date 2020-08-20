package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/minimum-knight-moves/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 * where n - number of steps to reach result
 */
public class MinimumKnightMoves {

    public int minKnightMoves(int x, int y) {
        return minKnightMoves(x, y, new HashMap<>());
    }

    private static int minKnightMoves(int x, int y, Map<String, Integer> cache) {
        if (x == 0 && y == 0) {
            return 0;
        }

        x = Math.abs(x);
        y = Math.abs(y);

        if (x + y == 2) {
            return 2;
        }

        String cacheKey = x + "~" + y;
        Integer cachedResult = cache.get(cacheKey);
        if (cachedResult != null) {
            return cachedResult;
        }

        int result = Math.min(minKnightMoves(x - 1, y - 2, cache), minKnightMoves(x - 2, y - 1, cache)) + 1;
        cache.put(cacheKey, result);

        return result;
    }
}
