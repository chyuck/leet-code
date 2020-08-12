package solutions;

/**
 * Solution for https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n - k)
 */
public class MaximumSumOf3NonOverlappingSubarrays {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] sums = getKSums(nums, k);

        int[] leftMaxSumIndexes = getLeftMaxSumIndexes(sums);
        int[] rightMaxSumIndexes = getRightMaxSumIndexes(sums);

        return getResult(sums, leftMaxSumIndexes, rightMaxSumIndexes, k);
    }

    private int[] getKSums(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        result[0] = sum;

        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] - nums[i - 1] + nums[i + k - 1];
        }

        return result;
    }

    private int[] getLeftMaxSumIndexes(int[] sums) {
        int[] result = new int[sums.length];

        int maxSumIndex = 0;
        result[maxSumIndex] = maxSumIndex;

        for (int i = 1; i < sums.length; i++) {
            if (sums[i] > sums[maxSumIndex]) {
                maxSumIndex = i;
            }

            result[i] = maxSumIndex;
        }

        return result;
    }

    private int[] getRightMaxSumIndexes(int[] sums) {
        int[] result = new int[sums.length];

        int maxSumIndex = sums.length - 1;
        result[maxSumIndex] = maxSumIndex;

        for (int i = sums.length - 2; i >= 0; i--) {
            if (sums[i] >= sums[maxSumIndex]) {
                maxSumIndex = i;
            }

            result[i] = maxSumIndex;
        }

        return result;
    }

    private int[] getResult(int[] sums, int[] leftMaxSumIndexes, int[] rightMaxSumIndexes, int k) {
        int[] result = new int[3];

        int maxSum = 0;

        for (int middleIndex = k; middleIndex < sums.length - k; middleIndex++) {
            int leftIndex = leftMaxSumIndexes[middleIndex - k];
            int rightIndex = rightMaxSumIndexes[middleIndex + k];

            int sum = sums[leftIndex] + sums[middleIndex] + sums[rightIndex];
            if (sum > maxSum) {
                maxSum = sum;
                result[0] = leftIndex;
                result[1] = middleIndex;
                result[2] = rightIndex;
            }
        }

        return result;
    }
}
