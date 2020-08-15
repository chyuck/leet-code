package solutions;

/**
 * Solution for https://leetcode.com/problems/maximal-square/ problem with
 * Time complexity: O(R * C)
 * Space complexity: O(C)
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int R = matrix.length;
        if (R == 0) {
            return 0;
        }
        int C = matrix[0].length;

        int maxLength = 0;

        int[] squareBottomRightCornerLengths = new int[C + 1];
        int topLeftLength = 0;

        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                if (matrix[r - 1][c - 1] == '1') {
                    int leftLength = squareBottomRightCornerLengths[c - 1];
                    int topLength = squareBottomRightCornerLengths[c];
                    int currentLength = Math.min(leftLength, Math.min(topLeftLength, topLength)) + 1;
                    maxLength = Math.max(maxLength, currentLength);

                    topLeftLength = squareBottomRightCornerLengths[c];
                    squareBottomRightCornerLengths[c] = currentLength;
                } else {
                    topLeftLength = squareBottomRightCornerLengths[c];
                    squareBottomRightCornerLengths[c] = 0;
                }
            }
        }

        return maxLength * maxLength;
    }
}
