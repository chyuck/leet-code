package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solution for https://leetcode.com/problems/remove-invalid-parentheses/ problem with
 * Time complexity: O(2 ^ n)
 * Space complexity: O(n)
 */
public class RemoveInvalidParentheses {

    private static class State {
        public final Set<String> results = new HashSet<>();
        public int minRemoved = Integer.MAX_VALUE;
    }

    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return Arrays.asList("");
        }

        State state = new State();

        generateResults(s, 0, 0, 0, 0, state, new StringBuilder());

        return new ArrayList<>(state.results);
    }

    private static void generateResults(String s, int i, int left, int right, int removed, State state, StringBuilder result) {

        if (i < s.length()) {
            char c = s.charAt(i);

            if (c == '(' || c == ')') {
                generateResults(s, i + 1, left, right, removed + 1, state, result);

                if (c == '(') {
                    result.append(c);
                    generateResults(s, i + 1, left + 1, right, removed, state, result);
                    result.deleteCharAt(result.length() - 1);
                } else if (left > right) {
                    result.append(c);
                    generateResults(s, i + 1, left, right + 1, removed, state, result);
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                result.append(c);
                generateResults(s, i + 1, left, right, removed, state, result);
                result.deleteCharAt(result.length() - 1);
            }

        } else {
            if (left != right) {
                return;
            }

            if (removed > state.minRemoved) {
                return;
            }

            if (removed < state.minRemoved) {
                state.minRemoved = removed;
                state.results.clear();
            }

            state.results.add(result.toString());
        }
    }
}
