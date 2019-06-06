package solutions;

/**
 * Solution for https://leetcode.com/problems/rotate-image/ problem with
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix.length == 0)
            return;

        final int length = matrix.length;

        // rows should be 0,1,...,(n-1)/2
        // for 2x2 matrix - 0
        // for 3x3 matrix - 0,1
        // for 4x4 matrix - 0,1
        // for 5x5 matrix - 0,1,2
        final int rowMax = (length - 1) / 2;

        for (int row = 0; row <= rowMax; row++) {
            // for cols should start from 0-0th row, 1-1st row, 2-2nd row, ...
            // for cols should end at (n-2)-0th row, (n-3)-1st row, (n-4)-2nd row, ...
            for (int col = row; col <= length - row - 2; col++) {
                // temp variables for row, col, value
                int r = row;
                int c = col;
                int value = matrix[r][c];

                while (true) {
                    // [new row] = [old col]
                    // [new col] = n - [old row] - 1
                    final int newRow = c;
                    final int newCol = length - r - 1;
                    final int newValue = matrix[newRow][newCol];

                    // set new value for cell
                    matrix[newRow][newCol] = value;

                    // quit loop when came to the same cell
                    if (newRow == row && newCol == col)
                        break;

                    // update temp variables
                    r = newRow;
                    c = newCol;
                    value = newValue;

                }
            }
        }
    }
}
