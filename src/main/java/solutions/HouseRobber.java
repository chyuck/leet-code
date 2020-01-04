package solutions;

/**
 * Solution for https://leetcode.com/problems/house-robber/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class HouseRobber {

    public int rob(int[] nums) {
        // f(1) = nums[0]
        // f(2) = max(nums[0], nums[1])
        // f(3) = max(nums[2] + nums[0], nums[1]) = max(nums[2] + f(1), f(2))
        // f(4) = max(nums[3] + f(2), f(3))
        // f(n) = max(nums[n-1] + f(n-2), f(n-1))

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int prev_prev = 0;
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = Math.max(nums[i] + prev_prev, prev);
            prev_prev = prev;
            prev = curr;
        }

        return prev;
    }
}
