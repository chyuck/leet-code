package solutions;

/**
 * Solutions for https://leetcode.com/problems/valid-palindrome-ii/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        int p1 = 0, p2 = s.length() - 1;

        while (p1 < p2) {
            if (s.charAt(p1) != s.charAt(p2)) {
                return validPalindrome(s, p1 + 1, p2) || validPalindrome(s, p1, p2 - 1);
            }
            p1++;
            p2--;
        }

        return true;
    }

    private static boolean validPalindrome(String s, int p1, int p2) {
        while (p1 < p2) {
            if (s.charAt(p1) != s.charAt(p2)) {
                return false;
            }
            p1++;
            p2--;
        }

        return true;
    }
}
