package solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Solution for https://leetcode.com/problems/guess-the-word/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class GuessTheWord {

    private static final Random random = new Random();

    public void findSecretWord(String[] wordlist, Master master) {
        List<String> list = Arrays.asList(wordlist);

        while (!list.isEmpty()) {
            int index = random.nextInt(list.size());
            String testWord = list.get(index);

            int matches = master.guess(testWord);
            if (matches == testWord.length()) {
                return;
            }

            list = filter(list, testWord, matches);
        }
    }

    private static List<String> filter(List<String> words, String testWord, int matches) {
        return words.stream().
            filter(word -> countMatches(word, testWord) == matches).
            collect(Collectors.toList());
    }

    private static int countMatches(String word, String testWord) {
        int result = 0;

        for (int i = 0; i < testWord.length(); i++) {
            if (word.charAt(i) == testWord.charAt(i)) {
                result++;
            }
        }

        return result;
    }

    static class Master {
        private final String secret;
        private final Set<String> words;

        private int guessCount = 0;
        private boolean secretFound = false;

        public Master(String secret, String[] wordList) {
            this.secret = secret;
            this.words = new HashSet<>(Arrays.asList(wordList));
        }

        public int guess(String word) {
            guessCount++;

            if (!words.contains(word)) {
                return -1;
            }

            int result = 0;

            for (int i = 0; i < secret.length(); i++) {
                if (word.charAt(i) == secret.charAt(i)) {
                    result++;
                }
            }

            if (result == secret.length()) {
                secretFound = true;
            }

            return result;
        }

        public boolean solved() {
            return secretFound && guessCount <= 10;
        }
    }
}
