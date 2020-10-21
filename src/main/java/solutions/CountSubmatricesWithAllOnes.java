package solutions;

import java.util.Arrays;

/**
 * Solution for https://leetcode.com/problems/count-submatrices-with-all-ones/ problem with
 * Time complexity: O(N * N * M)
 * Space complexity: O(M)
 */
public class CountSubmatricesWithAllOnes {

    public int numSubmat(int[][] mat) {
        int N = mat.length, M = mat[0].length;

        int result = 0;

        for (int upperRow = 0; upperRow < N; upperRow++) {
            int[] continuousOnesInColumns = new int[M];
            Arrays.fill(continuousOnesInColumns, 1);

            for (int bottomRow = upperRow; bottomRow < N; bottomRow++) {
                for (int col = 0; col < M; col++) {
                    continuousOnesInColumns[col] &= mat[bottomRow][col];
                }

                result += numSubmatForRow(continuousOnesInColumns);
            }
        }

        return result;
    }

    private static int numSubmatForRow(int[] row) {
        int result = 0;
        int onesLength = 0;

        for (int value : row) {
            onesLength = value == 0 ? 0 : onesLength + 1;
            result += onesLength;
        }

        return result;
    }
}