package solutions;

import java.util.HashSet;
import java.util.Set;

import structures.Stack;

/**
 * Solution for https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = getIndexesToRemove(s);

        return removeIndexes(s, indexesToRemove);
    }

    private Set<Integer> getIndexesToRemove(String s) {
        Set<Integer> results = new HashSet<>();

        Stack<Integer> openParentheses = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                openParentheses.push(i);
            } else if (c == ')') {
                if (openParentheses.isEmpty()) {
                    results.add(i);
                } else {
                    openParentheses.pop();
                }
            }
        }

        while (!openParentheses.isEmpty()) {
            results.add(openParentheses.pop());
        }

        return results;
    }

    private String removeIndexes(String s, Set<Integer> indexesToRemove) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                char c = s.charAt(i);
                result.append(c);
            }
        }

        return result.toString();
    }
}
