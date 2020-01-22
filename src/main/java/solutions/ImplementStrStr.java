package solutions;

/**
 * Solution for https://leetcode.com/problems/implement-strstr/ problem with
 * Time complexity: O((N - L) * L)
 * Space complexity: O(1)
 * where N - haystack length, L - needle length
 */
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        if (haystack == null || haystack.length() == 0) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (startWith(haystack, i, needle)) {
                return i;
            }
        }

        return -1;
    }

    private static boolean startWith(String str, int startIndex, String term) {
        for (int i = 0; i < term.length(); i++) {
            if (str.charAt(startIndex + i) != term.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
