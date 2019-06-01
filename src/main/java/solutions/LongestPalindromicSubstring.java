package solutions;

/**
* Solution for https://leetcode.com/problems/longest-palindromic-substring problem with
*/
public class LongestPalindromicSubstring {

    /**
     * Expand around center solution
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            // find the odd length of longest palindrome around i center element
            final int lengthWithMiddleElement = findMaxPalindromeLengthAroundCenter(s, i, i);
            // find the even length of longest palindrome around i, i + 1 center elements
            final int lengthWithoutMiddleElement =
                    // check whether does it make sense to calculate max length palindrome
                    i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)
                        ? findMaxPalindromeLengthAroundCenter(s, i, i + 1) : 0;
            // calculate the longest length
            final int longestLength = Math.max(lengthWithMiddleElement, lengthWithoutMiddleElement);

            // check if found longer palindrome
            if (end - start + 1 < longestLength) {
                start = i - (longestLength - 1) / 2;
                end = i + longestLength / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int findMaxPalindromeLengthAroundCenter(final String s, final int i, final int j) {
        int left = i;
        int right = j;

        // next indexes must be within string range
        while (left >= 0 && right < s.length()) {
            // if corresponding elements on left and right do not match than it is not palindrome
            if (s.charAt(left) != s.charAt(right))
                break;

            // move 1 element left from center
            left--;
            // move 1 element right from center
            right++;
        }

        // rollback left decrement and right increment before returning
        return --right - ++left + 1;
    }

    /**
     * Dynamic programming solution
     * Time complexity: O(n^2)
     * Space complexity: O(n^2)
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return "";

        String result = "";

        final boolean[][] palindromes = new boolean[s.length()][s.length()];

        // n - length of substring
        for (int n = 0; n < s.length(); n++) {
            // i - start index on substring
            for (int i = 0; i + n < s.length(); i++) {
                // j - end of substring
                final int j = i + n;

                final boolean isPalindrome = isPalindrome(s, i, j, palindromes);

                // save calculated result to reuse it in future
                palindromes[i][j] = isPalindrome;

                // update longest palindrome
                if (isPalindrome && n + 1 > result.length())
                    result = s.substring(i, j + 1);
            }
        }

        return result;
    }

    private boolean isPalindrome(final String s, final int i, final int j, final boolean[][] palindromes) {
        // 1 element is always palindrome
        if (i == j) return true;

        final boolean areFirstAndLastEqual = s.charAt(i) == s.charAt(j);

        // 2 elements are palindrome only when they are equal
        if (j - i == 1) return areFirstAndLastEqual;

        // 3 and more elements are palindrome when
        // first and last elements are equal and
        // substring without first and last elements is palindrome
        return areFirstAndLastEqual && palindromes[i+1][j-1];
    }
}
