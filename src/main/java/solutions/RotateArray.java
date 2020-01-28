package solutions;

/**
 * Solution for https://leetcode.com/problems/rotate-array problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        if (k <= 0) {
            return;
        }
        if (k % nums.length == 0) {
            return;
        }

        int start = 0;

        int pointer = 0;
        int num = nums[pointer];

        for (int i = 1; i <= nums.length; i++) {
            int nextPointer = (pointer + k) % nums.length;
            int nextNum = nums[nextPointer];

            nums[nextPointer] = num;
            pointer = nextPointer;
            num = nextNum;

            if (pointer == start) {
                start++;
                pointer = start;
                num = nums[pointer];
            }
        }
    }
}
