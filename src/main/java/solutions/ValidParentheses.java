package solutions;

import java.util.Stack;

/**
 * Solution for https://leetcode.com/problems/valid-parentheses problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            if (stack.empty()) {
                return false;
            }

            char opened = stack.pop();
            boolean isValid = (c == ')' && opened == '(')
                || (c == '}' && opened == '{')
                || (c == ']' && opened == '[');

            if (!isValid) {
                return false;
            }
        }

        return stack.empty();
    }
}
