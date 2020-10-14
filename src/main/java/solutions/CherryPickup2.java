package solutions;

/**
 * Solution for https://leetcode.com/problems/cherry-pickup-ii/ problem with
 * Time complexity: O(n * m * m)
 * Space complexity: O(n * m * m)
 * where n, m - dimensions of the grid
 */
public class CherryPickup2 {

    public int cherryPickup(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int[][][] cache = new int[n][m][m];
        for (int r = 0; r < n; r++) {
            for (int c1 = 0; c1 < m; c1++) {
                for (int c2 = 0; c2 < m; c2++) {
                    cache[r][c1][c2] = -1;
                }
            }
        }

        return cherryPickup(grid, 0, 0, m - 1, cache);
    }

    private static int cherryPickup(int[][] grid, int row, int col1, int col2, int[][][] cache) {
        if (col1 < 0 || col1 >= grid[0].length || col2 < 0 || col2 >= grid[0].length) {
            return 0;
        }

        if (cache[row][col1][col2] != -1) {
            return cache[row][col1][col2];
        }

        int result = grid[row][col1];
        if (col1 != col2) {
            result += grid[row][col2];
        }

        if (row < grid.length - 1) {
            int max = 0;

            for (int c1 = col1 - 1; c1 <= col1 + 1; c1++) {
                for (int c2 = col2 - 1; c2 <= col2 + 1; c2++) {
                    max = Math.max(max, cherryPickup(grid, row + 1, c1, c2, cache));
                }
            }

            result += max;
        }

        cache[row][col1][col2] = result;

        return result;
    }
}
