package solutions;

/**
 * Solutions for https://leetcode.com/problems/maximum-subarray problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int prevMax = 0;

        for (int num : nums) {
            int max = Math.max(num, prevMax + num);
            prevMax = max;

            result = Math.max(result, max);
        }

        return result;
    }
}
