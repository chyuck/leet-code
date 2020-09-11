package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/bulls-and-cows/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class BullsAndCows {

    public String getHint(String secret, String guess) {
        Map<Character, Integer> counts = new HashMap<>();

        int bulls = 0, cows = 0;

        for (int i = 0; i < guess.length(); i++) {
            char secretDigit = secret.charAt(i);
            char guessDigit = guess.charAt(i);

            if (secretDigit == guessDigit) {
                bulls++;
            } else {
                if (counts.getOrDefault(guessDigit, 0) > 0) {
                    cows++;
                }
                if (counts.getOrDefault(secretDigit, 0) < 0) {
                    cows++;
                }

                counts.put(secretDigit, counts.getOrDefault(secretDigit, 0) + 1);
                counts.put(guessDigit, counts.getOrDefault(guessDigit, 0) - 1);
            }
        }

        return String.format("%sA%sB", bulls, cows);
    }
}
