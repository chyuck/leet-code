package solutions;

/**
 * Solution for https://leetcode.com/problems/rotate-array problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int steps = k % nums.length;
        if (steps == 0) {
            return;
        }

        int start = 0;

        int index = start;
        int num = nums[index];

        for (int i = 0; i < nums.length; i++) {
            int nextIndex = (index + steps) % nums.length;

            int nextNum = nums[nextIndex];
            nums[nextIndex] = num;

            num = nextNum;
            index = nextIndex;

            if (index == start) {
                index = ++start;
                num = nums[index];
            }
        }
    }
}
