package solutions;

/**
 * Solution for https://leetcode.com/problems/number-of-islands problem with
 * Time complexity: O(M * N), where M,N - grid dimensions
 * Space complexity: O(1)
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;

        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // skip water
                if (grid[i][j] == '0')
                    continue;

                // discover whole island and convert island to water to skip in future
                discoverIsland(grid, i, j);
                result++;
            }
        }

        return result;
    }

    private void discoverIsland(char[][] grid, int row, int col) {
        // if out of bounds than treat as water and stop discovering
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return;

        // if water than stop discovering
        if (grid[row][col] == '0')
            return;

        // convert land to water to skip in future
        grid[row][col] = '0';

        // discover adjacent lands in four directions
        discoverIsland(grid, row - 1, col);
        discoverIsland(grid, row, col - 1);
        discoverIsland(grid, row, col + 1);
        discoverIsland(grid, row + 1, col);
    }
}
