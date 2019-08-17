package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution for https://leetcode.com/problems/longest-substring-without-repeating-characters/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 * where n - length of input string
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        // if input string is empty, return 0
        if (s == null || s.isEmpty())
            return 0;
        // if input string has only one character, return 1
        if (s.length() == 1)
            return 1;

        // hash set for storing characters for current substring
        Set<Character> chars = new HashSet<>();
        // add first character
        chars.add(s.charAt(0));

        // result, max substring with unique characters
        int result = 1;

        // pointers to start and end of current substring
        int start = 0, end = 1;

        // loop until end of substring go beyond end of string
        while (end < s.length()) {
            // save last character of substring
            char endChar = s.charAt(end);

            // if last character does not exist in current substring
            if (!chars.contains(endChar)) {
                // add to set of current characters
                chars.add(endChar);
                // move end of substring to next character
                end++;

            // if last character exists in current substring
            } else {

                // move start pointer to right one by one, until end character is found
                // remove all traversed characters from characters set of current substring
                while(true) {
                    // save start character
                    char startChar = s.charAt(start);

                    // remove from set
                    chars.remove(startChar);
                    // move start of substring to next character
                    start++;

                    // if found end character, then stop moving start pointer
                    if (startChar == endChar)
                        break;
                }
            }

            // calculate max so far found substring
            // use only validated unique characters
            result = Math.max(result, end - start);
        }

        // return result
        return result;
    }
}
