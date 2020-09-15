package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class XOfAKindInADeckOfCards {

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int card : deck) {
            Integer count = counts.getOrDefault(card, 0);
            counts.put(card, count + 1);
        }

        int result = 0;

        for (Integer count : counts.values()) {
            result = gcd(result, count);
        }

        return result >= 2;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
