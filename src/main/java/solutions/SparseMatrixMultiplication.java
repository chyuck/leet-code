package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/sparse-matrix-multiplication/ problem with
 * Time complexity: O(r1 * c1 + r2 * c2 + r1 * c2 * c1)
 * Space complexity: O(r1 * c1 + r2 * c2 + r1 * c2)
 * where A - r1 x c1, B - r2 x c2, c2 = r1
 */
public class SparseMatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        Map<Integer, Map<Integer, Integer>> aRows = createNotNulRows(A);
        Map<Integer, Map<Integer, Integer>> bColumns = createNotNulColumns(B);

        int[][] result = new int[A.length][B[0].length];

        for (int r = 0; r < result.length; r++) {
            for (int c = 0; c < result[0].length; c++) {
                result[r][c] = multiply(aRows.get(r), bColumns.get(c));
            }
        }

        return result;
    }

    private static Map<Integer, Map<Integer, Integer>> createNotNulRows(int[][] matrix) {
        Map<Integer, Map<Integer, Integer>> results = new HashMap<>();

        for (int r = 0; r < matrix.length; r++) {
            Map<Integer, Integer> row = new HashMap<>();

            for (int c = 0; c < matrix[0].length; c++) {
                int value = matrix[r][c];
                if (value != 0) {
                    row.put(c, value);
                }
            }

            if (!row.isEmpty()) {
                results.put(r, row);
            }
        }

        return results;
    }

    private static Map<Integer, Map<Integer, Integer>> createNotNulColumns(int[][] matrix) {
        Map<Integer, Map<Integer, Integer>> results = new HashMap<>();

        for (int c = 0; c < matrix[0].length; c++) {
            Map<Integer, Integer> column = new HashMap<>();

            for (int r = 0; r < matrix.length; r++) {
                int value = matrix[r][c];
                if (value != 0) {
                    column.put(r, value);
                }
            }

            if (!column.isEmpty()) {
                results.put(c, column);
            }
        }

        return results;
    }

    private static int multiply(Map<Integer, Integer> aRow, Map<Integer, Integer> bColumn) {
        if (aRow == null || bColumn == null) {
            return 0;
        }

        int result = 0;

        for (Map.Entry<Integer, Integer> aRowEntry : aRow.entrySet()) {
            Integer index = aRowEntry.getKey();
            Integer value1 = aRowEntry.getValue();

            Integer value2 = bColumn.getOrDefault(index, 0);

            result += value1 * value2;
        }

        return result;
    }
}
