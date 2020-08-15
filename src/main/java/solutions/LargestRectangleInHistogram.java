package solutions;

import java.util.Stack;

/**
 * Solution for https://leetcode.com/problems/largest-rectangle-in-histogram/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int result = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                result = calculateMaxArea(stack, heights, i, result);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result = calculateMaxArea(stack, heights, heights.length, result);
        }

        return result;
    }

    private static int calculateMaxArea(Stack<Integer> stack, int[] heights, int index, int maxArea) {
        int topIndex = stack.pop();

        int currentArea = stack.isEmpty()
            ? heights[topIndex] * index
            : heights[topIndex] * (index - stack.peek() - 1);

        return Math.max(maxArea, currentArea);
    }
}
