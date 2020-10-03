package solutions;

/**
 * Solution for https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/ problem with
 * Time complexity: O(k)
 * Space complexity: O(1)
 */
public class MaximumPointsYouCanObtainFromCards {

    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        int result = sum;

        for (int i = 1; i <= k; i++) {
            sum -= cardPoints[k - i];
            sum += cardPoints[cardPoints.length - i];

            result = Math.max(result, sum);
        }

        return result;
    }
}
