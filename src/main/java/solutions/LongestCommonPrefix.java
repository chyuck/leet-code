package solutions;

/**
 * Solution for https://leetcode.com/problems/longest-common-prefix/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 * where n - number of all characters in all strings
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];

                if (str.length() <= i || str.charAt(i) != c) {
                    return str.substring(0, i);
                }
            }
        }

        return strs[0];
    }
}
