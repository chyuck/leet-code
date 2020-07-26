package solutions;

/**
 * Solution for https://leetcode.com/problems/max-consecutive-ones-iii/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MaxConsecutiveOnes3 {

    public int longestOnes(int[] A, int K) {
        if (A.length <= K) {
            return A.length;
        }

        int result = 0;

        int left = 0;

        for (int right = 0; right < A.length; right++) {
            if (A[right] == 0) {
                K--;

                while (K < 0) {
                    if (A[left] == 0) {
                        K++;
                    }

                    left++;
                }
            }

            if (K >= 0) {
                result = Math.max(result, right - left + 1);
            }
        }

        return result;
    }
}
