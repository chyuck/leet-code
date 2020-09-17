package solutions;

import java.util.Stack;

/**
 * Solution for https://leetcode.com/problems/validate-stack-sequences/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 * where n - length of pushed/popped array
 */
public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int poppedIndex = 0;

        for (int p : pushed) {
            stack.push(p);

            while (!stack.isEmpty() && poppedIndex < popped.length && stack.peek() == popped[poppedIndex]) {
                stack.pop();
                poppedIndex++;
            }
        }

        return stack.empty();
    }
}
