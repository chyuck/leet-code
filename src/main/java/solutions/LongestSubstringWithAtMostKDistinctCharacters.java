package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/ problem with
 * Time complexity: O(n)
 * Space complexity: O(k)
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

    private static class Pointers {
        int left = 0;
        int right = 0;
    }

    private static class Result {
        int maxLength = 0;
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {

        }

        if (k == 0) {
            return 0;
        }

        Pointers pointers = new Pointers();
        Result result = new Result();

        Map<Character, Integer> counts = new HashMap<>();

        while (pointers.right < s.length()) {
            moveRightPointer(s, k, pointers, result, counts);
            moveLeftPointer(s, k, pointers, counts);
        }

        return result.maxLength;
    }

    private void moveRightPointer(String s, int k, Pointers pointers, Result result, Map<Character, Integer> counts) {
        while (pointers.right < s.length()) {
            char c = s.charAt(pointers.right);
            Integer count = counts.getOrDefault(c, 0);
            counts.put(c, count + 1);

            pointers.right++;

            if (counts.size() > k) {
                break;
            }

            result.maxLength = Math.max(result.maxLength, pointers.right - pointers.left);
        }
    }

    private void moveLeftPointer(String s, int k, Pointers pointers, Map<Character, Integer> counts) {
        while (counts.size() > k) {
            char c = s.charAt(pointers.left);
            Integer count = counts.get(c);
            if (count > 1) {
                counts.put(c, count - 1);
            } else {
                counts.remove(c);
            }

            pointers.left++;
        }
    }
}
