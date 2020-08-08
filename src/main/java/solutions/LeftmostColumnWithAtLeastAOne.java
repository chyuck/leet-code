package solutions;

import java.util.Arrays;
import java.util.List;

/**
 * Solution for https://leetcode.com/problems/leftmost-column-with-at-least-a-one/ problem with
 * Time complexity: O(n + m)
 * Space complexity: O(1)
 * where n,m - matrix dimensions
 */
public class LeftmostColumnWithAtLeastAOne {

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int rows = dimensions.get(0);
        int cols = dimensions.get(1);

        int result = -1;

        int row = 0;
        int col = cols - 1;

        while (true) {
            int value = binaryMatrix.get(row, col);

            if (value == 1) {
                if (col == 0) {
                    return 0;
                } else {
                    result = col;
                    col--;
                }
            } else {
                if (row == rows - 1) {
                    return result;
                } else {
                    row++;
                }
            }
        }
    }

    static class BinaryMatrix {
        private final int[][] matrix;
        private final List<Integer> dimensions;

        public BinaryMatrix(int[][] matrix) {
            this.matrix = matrix;
            this.dimensions = Arrays.asList(matrix.length, matrix[0].length);
        }

        public int get(int row, int col) {
            return matrix[row][col];
        }

        public List<Integer> dimensions() {
            return this.dimensions;
        }
    }
}
