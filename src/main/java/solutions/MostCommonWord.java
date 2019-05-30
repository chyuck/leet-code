package solutions;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Solution for https://leetcode.com/problems/most-common-word/ problem with
 * Time complexity: O(P + B), where P - paragraph length and B - banned length
 * Space complexity: O(P + B)
 */
public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.isEmpty())
            return null;

        // add banned words into hash set
        final HashSet<String> bannedWords = new HashSet<>(banned.length);
        for (String bannedWord: banned) {
            bannedWords.add(bannedWord);
        }

        int resultOccurrences = 0;
        String result = null;

        final HashMap<String, Integer> wordsToCounts = new HashMap<>();

        // word builder to accumulate characters
        StringBuilder wordBuilder = new StringBuilder();

        for(int i = 0; i < paragraph.length(); i++) {
            final char ch = paragraph.charAt(i);

            // accumulate word characters in lower case
            if (Character.isLetter(ch)) {
                wordBuilder.append(Character.toLowerCase(ch));

                // force word processing for the last character in paragraph
                if (i < paragraph.length() - 1)
                    continue;
            }

            // get word from string builder
            final String word = wordBuilder.toString();

            // ignore empty words
            if (word.isEmpty())
                continue;

            // whole word in lower case is collected

            // ignore banned word
            if (bannedWords.contains(word)) {
                // reset word builder
                wordBuilder = new StringBuilder();
                continue;
            }

            // get word count
            final Integer wordCount = wordsToCounts.getOrDefault(word, 0) + 1;

            // update hash map counts
            wordsToCounts.put(word, wordCount);

            // update result
            if (resultOccurrences < wordCount) {
                resultOccurrences = wordCount;
                result = word;
            }

            // reset word builder
            wordBuilder = new StringBuilder();
        }

        return result;
    }
}
