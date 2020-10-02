package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Solution for https://leetcode.com/problems/expressive-words/ problem with
 * Time complexity: O(W * S)
 * Space complexity: O(S)
 * where S - length of S, W - size of "words" array
 */
public class ExpressiveWords {

    public int expressiveWords(String S, String[] words) {
        WordInfo sInfo = createWordInfo(S);

        int result = 0;

        for (String word : words) {
            WordInfo wordInfo = createWordInfo(word);

            if (isStretchy(sInfo, wordInfo)) {
                result++;
            }
        }

        return result;
    }

    private static class WordInfo {
        private final String key;
        private final List<Integer> counts;

        private WordInfo(String key, List<Integer> counts) {
            this.key = key;
            this.counts = counts;
        }
    }

    private static WordInfo createWordInfo(String str) {
        StringBuilder key = new StringBuilder();
        List<Integer> counts = new ArrayList<>();

        int index = 0;

        while (index < str.length()) {
            char letter = str.charAt(index);

            int count = 0;
            while (index < str.length() && letter == str.charAt(index)) {
                count++;
                index++;
            }

            key.append(letter);
            counts.add(count);
        }

        return new WordInfo(key.toString(), counts);
    }

    private static boolean isStretchy(WordInfo sInfo, WordInfo wordInfo) {
        if (!Objects.equals(wordInfo.key, sInfo.key)) {
            return false;
        }

        for (int i = 0; i < wordInfo.counts.size(); i++) {
            Integer wordCount = wordInfo.counts.get(i);
            Integer sCount = sInfo.counts.get(i);

            if (wordCount == sCount) {
                continue;
            }

            if (wordCount > sCount) {
                return false;
            }

            if (sCount < 3) {
                return false;
            }
        }

        return true;
    }
}
