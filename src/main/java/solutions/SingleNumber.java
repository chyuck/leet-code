package solutions;

/**
 * Solution for https://leetcode.com/problems/single-number/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }
}
