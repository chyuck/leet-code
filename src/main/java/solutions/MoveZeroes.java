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

        int zeroPointer = 0;
        int nonZeroPointer = 0;

        while (nonZeroPointer < nums.length) {
            if (nums[nonZeroPointer] == 0) {
                nonZeroPointer++;
            } else {
                if (zeroPointer < nonZeroPointer) {
                    nums[zeroPointer] = nums[nonZeroPointer];
                    nums[nonZeroPointer] = 0;
                }
                zeroPointer++;
                nonZeroPointer++;
            }
        }
    }
}
