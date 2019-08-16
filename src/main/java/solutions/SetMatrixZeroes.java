package solutions;

/**
 * Solution for https://leetcode.com/problems/set-matrix-zeroes/ problem with
 * Time complexity: O(n * m)
 * Space complexity: O(1)
 * where n,m - matrix dimensions
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        // if matrix is empty, don't need to do anything
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        // save matrix dimensions
        int n = matrix.length, m = matrix[0].length;

        // save whether first row has any zeros
        boolean firstRowHasZero = false;
        for (int col = 0; col < m; col++) {
            if (matrix[0][col] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        // save whether first column has any zeros
        boolean firstColumnHasZero = false;
        for (int row = 0; row < n; row++) {
            if (matrix[row][0] == 0) {
                firstColumnHasZero = true;
                break;
            }
        }

        // traverse whole matrix without first row and column
        // set zeros to first row and column, if element has zero
        for (int row = 1; row < n; row++) {
            for (int col = 1; col < m; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        // traverse whole matrix without first row and column
        // set zeros to elements that have first column or row with zero
        for (int row = 1; row < n; row++) {
            for (int col = 1; col < m; col++) {
                if (matrix[0][col] == 0 || matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        // if first row had zeros at the beginning
        // set whole first row with zeros
        if (firstRowHasZero) {
            for (int col = 0; col < m; col++) {
                matrix[0][col] = 0;
            }
        }

        // if first column had zeros at the beginning
        // set whole first column with zeros
        if (firstColumnHasZero) {
            for (int row = 0; row < n; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}
