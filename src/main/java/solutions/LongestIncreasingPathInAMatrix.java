package solutions;

/**
 * Solution for https://leetcode.com/problems/longest-increasing-path-in-a-matrix/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class LongestIncreasingPathInAMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int result = 0;

        Integer[][] cache = new Integer[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                int path = dfs(row, col, matrix, Integer.MIN_VALUE, cache);
                result = Math.max(result, path);
            }
        }

        return result;
    }

    private static final int[][] DIRECTIONS = new int[][] {{0,-1}, {-1, 0}, {0,1}, {1,0}};

    private static int dfs(int row, int col, int[][] matrix, int prev, Integer[][] cache) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
            return 0;
        }

        int curr = matrix[row][col];

        if (curr <= prev) {
            return 0;
        }

        Integer cachedMaxPath = cache[row][col];
        if (cachedMaxPath != null) {
            return cachedMaxPath;
        }

        int maxPath = 0;

        for (int[] direction : DIRECTIONS) {
            int path = dfs(row + direction[0], col + direction[1], matrix, curr, cache);
            maxPath = Math.max(maxPath, path);
        }

        int result = 1 + maxPath;
        cache[row][col] = result;

        return result;
    }
}
