package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/first-unique-character-in-a-string problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        Map<Character, Integer> counts = new HashMap<>('z' - 'a' + 1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = counts.getOrDefault(c, 0);
            counts.put(c, count + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = counts.get(c);
            if (count == 1) {
                return i;
            }
        }

        return -1;
    }
}
