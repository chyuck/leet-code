package solutions;

/**
 * Solution for https://leetcode.com/problems/rotate-array problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        // if array is empty or has one element, then don't do anything
        if (nums == null || nums.length <= 1) return;
        // if all elements go to the same position, then don't do anything
        if (k % nums.length == 0) return;

        // current index to rotate
        int pointer = 0;
        // current value to rotate
        int value = nums[pointer];

        // start of rotation to track cyclic rotations
        int start = pointer;

        // do exactly length of num iterations
        for (int i = 0; i < nums.length; i++) {

            // calculate index after rotation
            int nextPointer = (pointer + k) % nums.length;
            // save value to be replaced by current value
            int nextValue = nums[nextPointer];

            // set current value to next index
            nums[nextPointer] = value;

            // update value by saved value
            value = nextValue;
            // update pointer by new index
            pointer = nextPointer;

            // if pointer came to start index
            if (pointer == start) {
                // increment start index
                start++;
                // set current index with new start index
                pointer = start;
                // update value from new current index
                value = nums[pointer];
            }
        }
    }
}
