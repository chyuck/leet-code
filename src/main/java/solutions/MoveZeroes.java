package solutions;

/**
 * Solutions for https://leetcode.com/problems/move-zeroes/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int pointer = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                continue;
            }

            if (pointer == i) {
                pointer++;
                continue;
            }

            nums[pointer++] = nums[i];
            nums[i] = 0;
        }
    }
}
