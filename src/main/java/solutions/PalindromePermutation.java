package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution for https://leetcode.com/problems/palindrome-permutation/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        Set<Character> chars = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean added = chars.add(c);
            if (!added) {
                chars.remove(c);
            }
        }

        return chars.size() <= 1;
    }
}
