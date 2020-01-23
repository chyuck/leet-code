package solutions;

/**
 * Solution for https://leetcode.com/problems/remove-duplicates-from-sorted-array/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int prev = nums[0];
        int counter = 1;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            if (curr != prev) {
                nums[counter] = curr;
                counter++;
                prev = curr;
            }
        }

        return counter;
    }
}
