package solutions;

/**
 * Solution for https://leetcode.com/problems/search-a-2d-matrix-ii/ problem with
 * Time complexity: O(n + m)
 * Space complexity: O(1)
 * where n,m - matrix dimensions
 */
public class Search2dMatrix2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        // if no values, return false
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        // IDEA: because structure is similar to BST with head in upper right corner
        // traverse matrix like BST
        // value at left is smaller, value at bottom is greater

        // save matrix dimensions
        int n = matrix.length, m = matrix[0].length;
        // start traversing matrix from upper right corner
        int row = 0, col = m - 1;

        // traverse until reaches outbound of matrix
        while (row < n && col >= 0) {
            // save current value
            int value = matrix[row][col];

            // target found, return true
            if (value == target)
                return true;

            // if value is greater than target, decrease value by moving to left
            if (value > target) {
                col--;
                continue;
            }

            // if value is less than target, increase value by moving to bottom
            row++;
        }

        // no target found, because we reached outbound of matrix
        return false;
    }
}
