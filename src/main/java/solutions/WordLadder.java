package solutions;

import java.util.*;

/**
 * Solution for https://leetcode.com/problems/word-ladder problem with
 * Time complexity: O(N * W)
 * Space complexity: O(N * W)
 * where N - number of words, W - length of word
 */
public class WordLadder {

    class WordWithLevel {
        public final String word;
        public final int level;

        public WordWithLevel(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // create hash map with all possible transformation of each word in given list
        // by replacing each changed letter with asterisk
        // for example "cat" will have "*at", "c*t" and "ca*" keys in hash map.
        // because two different word can lead to the same key, have hash map keep array of words as value
        final HashMap<String, ArrayList<String>> transformationsToWords = new HashMap<>();
        for (String word: wordList) {
            for (int i = 0; i < word.length(); i++) {
                final String key = word.substring(0, i) + '*' + word.substring(i + 1);
                final ArrayList<String> values = transformationsToWords.getOrDefault(key, new ArrayList<>());
                values.add(word);
                transformationsToWords.put(key, values);
            }
        }

        // using breadth first search find the shortest path from begin word to end word
        // BFS queue
        final Queue<WordWithLevel> wordsLevelsQueue = new LinkedList<>();
        // visited words
        final HashSet<String> visited = new HashSet<>();

        // add begin node
        wordsLevelsQueue.add(new WordWithLevel(beginWord, 1));
        visited.add(beginWord);

        while (!wordsLevelsQueue.isEmpty()) {
            // remove element from queue
            final WordWithLevel wordWithLevel = wordsLevelsQueue.remove();
            final String word = wordWithLevel.word;
            final int level = wordWithLevel.level;

            // iterate through all possible transformations with asterisk
            for (int i = 0; i < word.length(); i++) {
                // create possible transformation with asterisk
                final String key = word.substring(0, i) + '*' + word.substring(i + 1);
                // skip transformation that does not exist in word list
                if (!transformationsToWords.containsKey(key))
                    continue;

                // iterate through next words
                final ArrayList<String> nextWords = transformationsToWords.get(key);
                for (String nextWord: nextWords) {
                    // skip visited word
                    if (visited.contains(nextWord))
                        continue;

                    // end word is found
                    if (nextWord.equals(endWord))
                        return level + 1;

                    // mark word as visited
                    visited.add(nextWord);

                    // push to queue with incremented level
                    final WordWithLevel nextWordWithLevel = new WordWithLevel(nextWord, level + 1);
                    wordsLevelsQueue.add(nextWordWithLevel);
                }
            }

        }

        // end word is not found
        return 0;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        // convert word list to word hash set for faster search
        final HashSet<String> wordSet = new HashSet<>(wordList);

        // no end word in word list
        if (!wordSet.contains(endWord))
            return 0;

        // using breadth first search find the shortest path from begin word to end word
        // BFS queue
        Queue<String> queue = new LinkedList<>();
        // add begin node
        queue.add(beginWord);

        int level = 1;

        // Iterate level by level
        while (!queue.isEmpty()) {
            // save queue size, which corresponds size of current level, because it can change
            final int currentLevelSize = queue.size();

            // iterate through all words on current level
            for (int i = 0; i < currentLevelSize; i++) {
                // pop word from queue
                final String word = queue.remove();
                // convert word to char array
                final char[] wordArray = word.toCharArray();

                // iterate through each character in word
                for (int j = 0; j < wordArray.length; j++) {
                    // save original character to set back after manipulations
                    final char originalChar = wordArray[j];

                    // iterate through all possible characters from 'a' to 'z'
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        // replace character
                        wordArray[j] = ch;
                        final String nextLevelWord = new String(wordArray);

                        // no word in word list
                        if (!wordSet.contains(nextLevelWord))
                            continue;

                        // end word found
                        if (nextLevelWord.equals(endWord))
                            return level + 1;

                        // remove word from word list to skip in future
                        wordSet.remove(nextLevelWord);

                        // add word for the next level processing
                        queue.add(nextLevelWord);
                    }

                    // set back original character
                    wordArray[j] = originalChar;
                }
            }
            // increment level because queue has only words from the next level
            level++;
        }

        // end word is not found
        return 0;
    }
}
