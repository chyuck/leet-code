package solutions;

/**
 * Solution for https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MaximumSumOfTwoNonOverlappingSubarrays {

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        convertToPrefixSums(A);

        int result = getSum(A, 0, L + M - 1);

        int lLeftMax = getSum(A, 0, L - 1);
        int mLeftMax = getSum(A, 0, M - 1);

        for (int i = L + M; i < A.length; i++) {
            int lLeftSum = getSum(A, i - L - M + 1, i - M);
            int lRightSum = getSum(A, i - L + 1, i);
            lLeftMax = Math.max(lLeftMax, lLeftSum);

            int mLeftSum = getSum(A, i - L - M + 1, i - L);
            int mRightSum = getSum(A, i - M + 1, i);
            mLeftMax = Math.max(mLeftMax, mLeftSum);

            int sum = Math.max(lLeftMax + mRightSum, mLeftMax + lRightSum);
            result = Math.max(result, sum);
        }

        return result;
    }

    private static void convertToPrefixSums(int[] A) {
        for (int i = 1; i < A.length; i++) {
            A[i] += A[i - 1];
        }
    }

    private static int getSum(int A[], int start, int end) {
        return A[end] - (start > 0 ? A[start - 1] : 0);
    }
}
