package solutions;

/**
 * Solution for https://leetcode.com/problems/missing-number/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int expectedSum = nums.length;
        int actualSum = 0;

        for (int i = 0; i < nums.length; i++) {
            expectedSum += i;
            actualSum += nums[i];
        }

        return expectedSum - actualSum;
    }
}
