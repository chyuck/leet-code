package solutions;

/**
 * Solution for https://leetcode.com/problems/valid-number/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ValidNumber {

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        return isValidNumber(s.trim());
    }

    private static boolean isValidNumber(String s) {
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberBeforeE = false;
        boolean numberAfterE = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'e') {
                if (eSeen || !numberBeforeE) {
                    return false;
                }
                eSeen = true;
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else if (c == '.') {
                if (pointSeen || eSeen) {
                    return false;
                }
                pointSeen = true;
            } else if ('0' <= c && c <= '9') {
                if (eSeen) {
                    numberAfterE = true;
                } else {
                    numberBeforeE = true;
                }
            } else {
                return false;
            }
        }

        return (numberBeforeE && !eSeen) || (numberBeforeE && eSeen && numberAfterE);
    }
}
