package solutions;

/**
 * Solution for https://leetcode.com/problems/edit-distance/ problem with
 * Time complexity: O(N * M)
 * Space complexity: O(N * M)
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int N = word1.length(), M = word2.length();

        int[][] dp = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= M; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int distance1 = dp[i][j - 1] + 1;
                int distance2 = dp[i -1][j] + 1;
                int distance3 = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;

                dp[i][j] = Math.min(distance1, Math.min(distance2, distance3));
            }
        }

        return dp[N][M];
    }
}
