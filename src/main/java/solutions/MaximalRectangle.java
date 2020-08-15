package solutions;

import java.util.Stack;

/**
 * Solution for https://leetcode.com/problems/maximal-rectangle/ problem with
 * Time complexity: O(R * C)
 * Space complexity: O(C)
 */
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int R = matrix.length;
        if (R == 0) {
            return 0;
        }
        int C = matrix[0].length;

        int result = 0;

        int[] heights = new int[C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (matrix[r][c] == '1') {
                    heights[c]++;
                } else {
                    heights[c] = 0;
                }
            }

            int area = largestRectangleArea(heights);
            result = Math.max(result, area);
        }

        return result;
    }

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
