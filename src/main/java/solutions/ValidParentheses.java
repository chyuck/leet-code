package solutions;

import java.util.Stack;

/**
 * Solution for https://leetcode.com/problems/valid-parentheses problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;

        final Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            final char ch = s.charAt(i);

            // push to stack all open parentheses
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }

            // no open parentheses for closed one
            if (stack.isEmpty())
                return false;

            // closed parentheses should match open
            if (ch == ')' && stack.pop() != '(')
                return false;

            if (ch == ']' && stack.pop() != '[')
                return false;

            if (ch == '}' && stack.pop() != '{')
                return false;
        }

        // check whether all open parentheses have closed ones
        return stack.isEmpty();
    }
}
