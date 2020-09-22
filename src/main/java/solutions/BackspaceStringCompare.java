package solutions;

/**
 * Solution for https://leetcode.com/problems/backspace-string-compare/ problem with
 * Time complexity: O(S + T)
 * Space complexity: O(1)
 */
public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        int s = S.length() - 1, t = T.length() - 1;


        while (s >= 0 || t >= 0) {
            s = moveToCharacter(S, s);
            t = moveToCharacter(T, t);

            if (s >= 0 && t >= 0 && S.charAt(s) != T.charAt(t)) {
                return false;
            }

            if ((s >= 0) != (t >= 0)) {
                return false;
            }

            s--;
            t--;
        }

        return true;
    }

    private static int moveToCharacter(String str, int index) {
        int skip = 0;

        while (index >= 0) {
            if (str.charAt(index) == '#') {
                skip++;
            } else if (skip > 0) {
                skip--;
            } else {
                break;
            }

            index--;
        }

        return index;
    }
}
