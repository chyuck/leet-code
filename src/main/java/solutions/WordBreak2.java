package solutions;

import java.util.*;

/**
 * Solution for https://leetcode.com/problems/word-break-ii/ problem with
 * Time complexity: O(N * S)
 * Space complexity: O(N * S)
 * where N - number of words, S - length of string
 */
public class WordBreak2 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        // calculate max word length and convert words dictionary to hash map for faster performance
        int maxWordLength = 0;
        Set<String> words = new HashSet<>();
        for (String word : wordDict) {
            maxWordLength = Math.max(maxWordLength, word.length());
            words.add(word);
        }

        // cache for constructed parts of input string
        Map<String, List<List<String>>> cache = new HashMap<>();

        List<List<String>> sentences = constructSentences(s, words, cache, maxWordLength);

        // convert results from list of strings to space separated strings
        List<String> results = new ArrayList<>();
        for (List<String> sentence : sentences) {
            String result = String.join(" ", sentence);
            results.add(result);
        }

        return results;
    }

    private List<List<String>> constructSentences(String s, Set<String> words, Map<String, List<List<String>>> cache, int maxWordLength) {

        List<List<String>> results = new ArrayList<>();

        // calculate upper bound of possible word
        int upperBound = Math.min(maxWordLength, s.length());

        for (int i = 1; i <= upperBound; i++) {

            // candidate for word
            String word = s.substring(0, i);

            // word dictionary does not contain candidate word
            if (!words.contains(word)) continue;

            // end of input string, add current word as result
            if (i == s.length()) {
                List<String> result = new ArrayList<>();
                result.add(word);
                results.add(result);
                break;
            }

            // get next part of string without found word
            String nextPart = s.substring(i);

            // check cache for next part and if it does not exist calculate it and add to cache
            List<List<String>> nextPartSentences = cache.get(nextPart);
            if (nextPartSentences == null) {
                nextPartSentences = constructSentences(nextPart, words, cache, maxWordLength);
                cache.put(nextPart, nextPartSentences);
            }

            // add next part words to current word, and add to results
            for (List<String> nextPartSentence : nextPartSentences) {
                List<String> result = new ArrayList<>();
                result.add(word);
                result.addAll(nextPartSentence);

                results.add(result);
            }
        }

        // return results
        return results;
    }
}
