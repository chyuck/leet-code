package solutions;

/**
 * Solutions for https://leetcode.com/problems/maximum-subarray problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MaximumSubarray {

    /**
     * Kadane's algorithm
     * https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane's_algorithm
     */
    public int maxSubArray(int[] nums) {
        // max sum for all sub-arrays between 0 and i - 1 numbers
        int previousMaxSum = nums[0];
        // max sum among all max sums
        int maxSum = previousMaxSum;

        // start from 2nd element, because 1st already used for setting initial max sums
        for (int i = 1; i < nums.length; i++) {
            // calculate max sum for all sub-arrays between 0 and i numbers
            // it is maximum of:
            //   - previous max sum + current number
            //   - current number
            int currentMaxSum = Math.max(previousMaxSum + nums[i], nums[i]);
            // update result is current max is greater than all previous maxes
            maxSum = Math.max(maxSum, currentMaxSum);
            // update previous max sum for next iteration
            previousMaxSum = currentMaxSum;
        }

        return maxSum;
    }
}
