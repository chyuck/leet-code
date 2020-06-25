package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/verifying-an-alien-dictionary/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 * where n - total length of all words
 */
public class VerifyingAnAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> alphabet = createAlphabet(order);

        for (int i = 1; i < words.length; i++) {
            if (!isOrdered(words[i - 1], words[i], alphabet)) {
                return false;
            }
        }

        return true;
    }

    private static Map<Character, Integer> createAlphabet(String order) {
        Map<Character, Integer> alphabet = new HashMap<>(26);

        char[] orderChars = order.toCharArray();
        for (int i = 0; i < orderChars.length; i++ ) {
            alphabet.put(orderChars[i], i);
        }

        return alphabet;
    }

    private static boolean isOrdered(String word1, String word2, Map<Character, Integer> alphabet) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        int minLength = Math.min(chars1.length, chars2.length);

        for (int j = 0; j < minLength; j++) {
            int order1 = alphabet.get(chars1[j]);
            int order2 = alphabet.get(chars2[j]);

            if (order1 == order2) {
                continue;
            }

            return order1 < order2;
        }

        return chars1.length <= chars2.length;
    }
}
