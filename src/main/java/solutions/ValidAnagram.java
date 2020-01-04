package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/valid-anagram problem with
 * Time complexity: O(S + T)
 * Space complexity: O(1)
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> counts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = counts.getOrDefault(c, 0);
            counts.put(c, count + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = t.charAt(i);
            Integer count = counts.getOrDefault(c, 0);

            if (count == 0) {
                return false;
            } else if (count == 1) {
                counts.remove(c);
            } else {
                counts.put(c, count - 1);
            }
        }

        return counts.size() == 0;
    }
}