package solutions;

import java.util.Stack;

/**
 * Solution for https://leetcode.com/problems/simplify-path/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] parts = path.split("/");

        Stack<String> stack = new Stack<>();

        for (String part : parts) {
            if (part.equals(".") || part.equals("")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        return toPath(stack);
    }

    private static String toPath(Stack<String> stack) {
        if (stack.empty()) {
            return "/";
        }

        StringBuilder result = new StringBuilder();

        for (String part : stack) {
            result.append('/');
            result.append(part);
        }

        return result.toString();
    }
}
