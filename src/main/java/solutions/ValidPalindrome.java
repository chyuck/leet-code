package solutions;

/**
 * Solutions for https://leetcode.com/problems/valid-palindrome/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int p1 = 0;
        int p2 = s.length() - 1;

        while (p1 < p2) {
            char c1 = Character.toLowerCase(s.charAt(p1));
            if (!isAlphaNumeric(c1)) {
                p1++;
                continue;
            }

            char c2 = Character.toLowerCase(s.charAt(p2));
            if (!isAlphaNumeric(c2)) {
                p2--;
                continue;
            }

            if (c1 != c2) {
                return false;
            }

            p1++;
            p2--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
