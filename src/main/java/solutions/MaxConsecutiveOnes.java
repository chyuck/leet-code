package solutions;

/**
 * Solution for https://leetcode.com/problems/max-consecutive-ones/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                result = Math.max(result, count);
                count = 0;
            }
        }

        return Math.max(result, count);
    }
}
