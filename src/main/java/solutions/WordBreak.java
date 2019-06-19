package solutions;

import java.util.*;

/**
 * Solution for https://leetcode.com/problems/word-break/ problem with
 * Time complexity: O(S ^ 2)
 * Space complexity: O(N + S)
 * where N - number of words, S - length of string
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) return true;
        if (wordDict.size() == 0) return false;

        // convert list list of words to hash set, for faster search
        Set<String> words = new HashSet<>(wordDict);

        // keep result for string divided by two parts
        // index of array is a first index of right part
        boolean[] cache = new boolean[s.length() + 1];
        // set true for the left part as empty string
        cache[0] = true;

        // loop through first index of right part
        for (int i = 1; i <= s.length(); i++) {

            // looping left part from max possible length to empty string
            // splitting string into 3 parts: left, center and right
            for (int j = i - 1; j >= 0; j--) {
                // trying to find left part which can be broken into words
                // because otherwise does not make sense to check center part
                if (!cache[j]) continue;

                // take center part
                String center = s.substring(j, i);
                // if center is in words list (proved that left can be broken into words)
                // then whole left part, which is left + center, can be broken into words
                if (words.contains(center)) {
                    // set result for future iterations
                    cache[i] = true;
                    // no need to search other left + center combinations that can be broken into words
                    break;
                }
            }
        }

        // return true, if whole string can be broken into parts
        return cache[s.length()];
    }
}
