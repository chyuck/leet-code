package solutions;

import java.util.*;

/**
 * Solution for https://leetcode.com/problems/word-ladder-ii problem with
 * Time complexity: O(N * W)
 * Space complexity: O(N * W)
 * where N - number of words, W - length of word
 */
public class WordLadder2 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // return empty result for empty input
        if (wordList == null || wordList.size() == 0) return new ArrayList<>();

        // convert word list t0 hash set for faster access
        final Set<String> wordSet = new HashSet<>(wordList);

        // graph of words from begin word to end word, which contains word mapping to its next level words
        final HashMap<String, List<String>> graph = new HashMap<>();

        // hash map of word levels
        final HashMap<String, Integer> levels = new HashMap<>();

        // using BFS search end word, starting from begin word, and return results
        // compose graph of words and levels
        final boolean found = bfs(beginWord, endWord, wordSet, graph, levels);
        // return empty result, if end word cannot be found
        if (!found) return new ArrayList<>();

        // all optimal ladders from begin word to end word
        final List<List<String>> ladders = new ArrayList<>();

        // using DFS on graph of words, compose all optimal ladders from begin word to end word
        dfs(beginWord, endWord, graph, levels, ladders, new ArrayList<>());

        return ladders;
    }

    private static boolean bfs(final String beginWord, final String endWord, final Set<String> wordSet,
                               final HashMap<String, List<String>> graph, final HashMap<String, Integer> levels) {
        // BFS queue
        final Queue<String> queue = new LinkedList<>();
        // add begin word
        queue.add(beginWord);
        levels.put(beginWord, 0);

        // iterate queue until it is empty
        while (!queue.isEmpty()) {

            boolean endWordFound = false;

            // save current level size
            final int levelSize = queue.size();

            // iterate through all words of current level
            for (int i = 0; i < levelSize; i++) {

                // get current word from queue
                final String word = queue.remove();

                // get current word level
                final Integer level = levels.get(word);

                for (String nextWord: getNextWords(word, wordSet)) {
                    // get or calculate next word level
                    final Integer nextLevel = levels.getOrDefault(nextWord, level + 1);
                    // skip, if next word is not from one of the next levels
                    if (nextLevel <= level) continue;

                    // update next word level
                    levels.put(nextWord, nextLevel);

                    // add next word to BFS queue
                    queue.add(nextWord);

                    // connect next word with current word in graph
                    final List<String> words = graph.getOrDefault(word, new ArrayList<>());
                    if (!words.contains(nextWord)) {
                        words.add(nextWord);
                        graph.put(word, words);
                    }

                    // if end word is found, continue current level, and quit at the end
                    if (nextWord.equals(endWord))
                        endWordFound = true;
                }
            }

            // quit after whole level traversed
            if (endWordFound)
                return true;
        }

        // no end word found
        return false;
    }

    private static List<String> getNextWords(final String word, final Set<String> wordSet) {
        final ArrayList<String> nextWords = new ArrayList<>();

        final char[] chars = word.toCharArray();

        // replace each character of word with all possible characters from 'a' to 'z'
        for (int i = 0; i < word.length(); i++) {
            // save original char
            final char originalChar = chars[i];

            for (char ch = 'a'; ch <= 'z'; ch++) {
                // skip, if next word is current word
                if (ch == originalChar) continue;

                chars[i] = ch;
                final String nextWord = String.valueOf(chars);

                // skip, if next word is not in list of allowed words
                if (!wordSet.contains(nextWord)) continue;

                nextWords.add(nextWord);
            }
            // put back original char
            chars[i] = originalChar;
        }

        return nextWords;
    }


    private static void dfs(final String word, final String endWord,
                            final HashMap<String, List<String>> graph, final HashMap<String, Integer> levels,
                            final List<List<String>> ladders, final List<String> ladder){

        // add current word to current ladder
        ladder.add(word);

        // if word is end word, clone ladder, and add to results
        if (word.equals(endWord)) {
            ladders.add(new ArrayList<>(ladder));
        } else {
            // get current word level
            final Integer level = levels.get(word);
            // get all next words
            final List<String> nextWords = graph.get(word);

            // graph can miss some words from last level
            if (nextWords != null) {
                for (String nextWord: nextWords) {
                    // if next word is not on next level from current word, skip it, because it is not optimal ladder
                    if (level + 1 != levels.get(nextWord)) continue;

                    // continue DFS
                    dfs(nextWord, endWord, graph, levels, ladders, ladder);
                }
            }
        }

        // remove current word to clean current ladder for reusing of top levels
        ladder.remove(ladder.size() - 1);
    }
}
