package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for https://leetcode.com/problems/word-search-ii problem with
 * Time complexity: O(N * M * L * W)
 * Space complexity: O(L * W)
 * where N, M - board dimensions, L - length of words array, W - average length of word
 */
public class WordSearch2 {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> results = new ArrayList<>();

        if (board.length == 0 || board[0].length == 0) return results;
        if (words.length == 0) return results;

        // build trie from words
        TrieNode trie = buildTrie(words);

        // iterate through all cells
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                search(board, row, col, trie, results);

                // all words found
                if (results.size() == words.length)
                    return results;
            }
        }

        return results;
    }

    private void search(char[][] board, int row, int col, TrieNode trie, List<String> results) {
        // check cell is not out of board
        if (row < 0 || row >= board.length) return;
        if (col < 0 || col >= board[0].length) return;

        // board letter
        char ch = board[row][col];

        // skip, if letter is visited
        if (ch == '*') return;

        // letter index in trie
        int index = ch - 'a';
        // trie node which correspond letter
        TrieNode nextNode = trie.children[index];

        // skip, because letter does not match
        if (nextNode == null)
            return;

        // whole word found
        if (nextNode.word != null) {
            // add word to results
            results.add(nextNode.word);
            // prevent duplicates in results
            nextNode.word = null;

            // do not return here because it can be other words that starts with current word
        }

        // prevent using this letter in this word
        board[row][col] = '*';

        // check next letter in adjacent cells: left, top, right, bottom
        search(board, row, col - 1, nextNode, results);
        search(board, row - 1, col, nextNode, results);
        search(board, row, col + 1, nextNode, results);
        search(board, row + 1, col, nextNode, results);

        // rollback cleared letter
        board[row][col] = ch;
    }

    private class TrieNode {
        String word;
        final TrieNode[] children;
        public TrieNode() {
            // 26 - number of possible letters
            children = new TrieNode[26];
        }
    }

    // https://en.wikipedia.org/wiki/Trie
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word: words) {

            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                // use as index values from 0-25 which corresponds to all letters from 'a' to 'z'
                int childrenIndex = word.charAt(i) - 'a';

                // no such letter, create new
                if (cur.children[childrenIndex] == null) {
                    cur.children[childrenIndex] = new TrieNode();
                }

                // move cursor to the next node
                cur = cur.children[childrenIndex];

            }

            // set word to the last node, to use as indicator of complete word
            cur.word = word;
        }

        return root;
    }

    public List<String> findWords2(char[][] board, String[] words) {
        List<String> results = new ArrayList<>();

        if (board.length == 0 || board[0].length == 0) return results;
        if (words.length == 0) return results;

        // loop through each cell on board until words are found
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                for (int index = 0; index < words.length; index++) {
                    String word = words[index];
                    // skip found word
                    if (word == null) continue;

                    // search word
                    if (search(board, word, 0, row, col)) {
                        // add found word to results
                        results.add(word);
                        // skip to search this word in future
                        words[index] = null;
                        // all words found
                        if (results.size() == words.length)
                            return results;
                    }
                }
            }
        }

        return results;
    }

    private boolean search(char[][] board, String word, int index, int row, int col) {
        // word is found
        if (word.length() <= index) return true;

        // out of board
        if (row < 0 || row >= board.length) return false;
        if (col < 0 || col >= board[0].length) return false;

        // letter does not match
        if (word.charAt(index) != board[row][col]) return false;

        // clear visited cell to skip in future
        board[row][col] = '*';

        // move to left, then top, then right, then bottom cells
        boolean found = search(board, word, index + 1, row, col - 1)
                || search(board, word, index + 1, row - 1, col)
                || search(board, word, index + 1, row, col + 1)
                || search(board, word, index + 1, row + 1, col);

        // rollback to original character
        board[row][col] = word.charAt(index);

        return found;
    }
}
