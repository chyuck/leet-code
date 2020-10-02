package solutions;

/**
 * Solution for https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/ problem with
 * Time complexity: O(R * C)
 * Space complexity: O(C)
 * where R - number of rows in M, C - number of columns in M
 */
public class LongestLineOfConsecutiveOneInMatrix {

    public int longestLine(int[][] M) {
        int rowCount = M.length;
        if (rowCount == 0) {
            return 0;
        }

        int colCount = M[0].length;

        int result = 0;

        int[][] prevRow = new int[colCount][4];

        for (int r = 0; r < rowCount; r++) {
            int[][] currRow = new int[colCount][4];

            for (int c = 0; c < colCount; c++) {
                int value = M[r][c];
                if (value == 0) {
                    continue;
                }

                currRow[c][0] = value + (c > 0 ? currRow[c - 1][0] : 0);
                currRow[c][1] = value + (c > 0 ? prevRow[c - 1][1] : 0);
                currRow[c][2] = value + prevRow[c][2];
                currRow[c][3] = value + (c < colCount - 1 ? prevRow[c + 1][3] : 0);

                int maxValue = Math.max(Math.max(currRow[c][0], currRow[c][1]), Math.max(currRow[c][2], currRow[c][3]));
                result = Math.max(result, maxValue);
            }

            prevRow = currRow;
        }

        return result;
    }
}
