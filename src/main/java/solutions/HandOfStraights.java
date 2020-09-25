package solutions;

import java.util.TreeMap;

/**
 * Solution for https://leetcode.com/problems/hand-of-straights/ problem with
 * Time complexity: O(n * log(n))
 * Space complexity: O(n)
 */
public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> orderedCards = new TreeMap<>();
        for (int card : hand) {
            Integer count = orderedCards.getOrDefault(card, 0);
            orderedCards.put(card, count + 1);
        }

        while (!orderedCards.isEmpty()) {
            Integer firstCard = orderedCards.firstKey();

            for (Integer card = firstCard; card < firstCard + W; card++) {
                Integer count = orderedCards.get(card);
                if (count == null) {
                    return false;
                }

                if (count == 1) {
                    orderedCards.remove(card);
                } else {
                    orderedCards.put(card, count - 1);
                }
            }
        }

        return true;
    }
}
