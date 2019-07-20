package solutions;

/**
 * Solution for https://leetcode.com/problems/valid-anagram problem with
 * Time complexity: O(S + T)
 * Space complexity: O(1)
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        // create array with each letter counter for s
        int[] chars = new int['z' - 'a' + 1];
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            // convert letter to index of 0 to 25
            int index = letter - 'a';
            // increment counter for each character
            chars[index]++;
        }

        // loop through t and validate that every letter matches letter in s
        for (int i = 0; i < t.length(); i++) {
            char letter = t.charAt(i);
            // convert letter to index of 0 to 25
            int index = letter - 'a';

            // if counter is zero, that means that t has letter that s does not have
            if (chars[index] == 0)
                return false;

            // decrement letter counter
            chars[index]--;
        }

        // with assumption that s length and t length are equal
        // all counters should be zeroes
        // and that means s is anagram of t
        return true;
    }
}