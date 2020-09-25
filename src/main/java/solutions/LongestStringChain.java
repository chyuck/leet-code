package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/longest-string-chain/ problem with
 * Time complexity: O(n * log(n) + n * s * s)
 * Space complexity: O(n * s)
 * where n - length of "words" array, s - max length of word in "words" array
 */
public class LongestStringChain {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int result = 0;

        Map<String, Integer> maxSubResults = new HashMap<>(words.length);

        for (String word : words) {
            int maxSubResult = 0;

            for (int i = 0; i < word.length(); i++) {
                String prevWord = word.substring(0, i) + word.substring(i + 1);
                int prevWordMaxSubResult = maxSubResults.getOrDefault(prevWord, 0);

                maxSubResult = Math.max(maxSubResult, prevWordMaxSubResult + 1);
            }

            result = Math.max(result, maxSubResult);

            maxSubResults.put(word, maxSubResult);
        }

        return result;
    }
}
