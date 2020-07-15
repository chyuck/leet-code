package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/add-and-search-word-data-structure-design/ problem with
 */
public class AddAndSearchWordDataStructureDesign {

    private class TrieNode {
        public final Map<Character, TrieNode> children = new HashMap<>();
        public boolean isWord = false;
    }

    private final TrieNode trie = new TrieNode();

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public void addWord(String word) {
        TrieNode node = trie;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            TrieNode existingChild = node.children.get(c);
            if (existingChild == null) {
                TrieNode child = new TrieNode();
                node.children.put(c, child);
                node = child;
            } else {
                node = existingChild;
            }
        }

        node.isWord = true;
    }

    /**
     * Time complexity: O(n * m)
     * Space complexity: O(n)
     */
    public boolean search(String word) {
        return search(word, 0, trie);
    }

    private static boolean search(String word, int index, TrieNode node) {
        for (int i = index; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '.') {
                for (TrieNode child : node.children.values()) {
                    if (search(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;

            } else {
                TrieNode child = node.children.get(c);
                if (child == null) {
                    return false;
                }

                node = child;
            }
        }

        return node.isWord;
    }
}
