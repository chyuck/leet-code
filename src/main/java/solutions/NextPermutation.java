package solutions;

/**
 * Solution for https://leetcode.com/problems/next-permutation/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int firstDecreasing = findFirstDecreasing(nums);
        if (firstDecreasing >= 0) {
            int minGreater = findMinGreater(nums, firstDecreasing);
            swap(nums, firstDecreasing, minGreater);
        }

        reverseRightSide(nums, firstDecreasing + 1);
    }

    private static int findFirstDecreasing(int[] nums) {
        int index = nums.length - 2;

        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }

        return index;
    }

    private static int findMinGreater(int[] nums, int firstDecreasing) {
        int index = nums.length - 1;

        while (nums[index] <= nums[firstDecreasing]) {
            index--;
        }

        return index;
    }

    private static void reverseRightSide(int[] nums, int startIndex) {
        int left = startIndex;
        int right = nums.length - 1;

        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
