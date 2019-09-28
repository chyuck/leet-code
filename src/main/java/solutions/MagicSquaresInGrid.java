package solutions;

/**
 * Solution for https://leetcode.com/problems/magic-squares-in-grid/ problem with
 * Time complexity: O(R * C)
 * Space complexity: O(1)
 */
public class MagicSquaresInGrid {

    public int numMagicSquaresInside(int[][] grid) {
        int R = grid.length, C = grid[0].length;

        if (R < 3 || C < 3)
            return 0;

        int result = 0;

        for (int row = 0; row < R - 2; row++) {
            for (int col = 0; col < C - 2; col++) {
                if (isMagicSquare(grid, row, col)){
                    result++;
                }
            }
        }

        return result;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col) {
        return allDistinct(grid, row, col) && allSumsEqual(grid, row, col);
    }

    private boolean allDistinct(int[][] grid, int row, int col) {
        boolean[] exist = new boolean[9];

        for (int r=row; r<=row+2; r++) {
            for (int c=col; c<=col+2; c++) {
                int value = grid[r][c];
                if (value < 1 || value > 9) return false;

                int index = value - 1;
                if (exist[index]) return false;

                exist[index] = true;
            }
        }

        return true;
    }

    private boolean allSumsEqual(int[][] grid, int row, int col) {
        return grid[row][col] + grid[row][col+1] + grid[row][col+2] == 15
                && grid[row+1][col] + grid[row+1][col+1] + grid[row+1][col+2] == 15
                && grid[row+2][col] + grid[row+2][col+1] + grid[row+2][col+2] == 15

                && grid[row][col] + grid[row+1][col] + grid[row+2][col] == 15
                && grid[row][col+1] + grid[row+1][col+1] + grid[row+2][col+1] == 15
                && grid[row][col+2] + grid[row+1][col+2] + grid[row+2][col+2] == 15

                && grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2] == 15
                && grid[row][col+2] + grid[row+1][col+1] + grid[row+2][col] == 15;
    }
}
