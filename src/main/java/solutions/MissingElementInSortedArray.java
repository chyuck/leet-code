package solutions;

/**
 * Solution for https://leetcode.com/problems/missing-element-in-sorted-array/ problem with
 * Time complexity: O(log(n))
 * Space complexity: O(1)
 */
public class MissingElementInSortedArray {

    public int missingElement(int[] nums, int k) {
        int totalMissedElements = getMissingElementsCount(nums, nums.length - 1);
        if (k > totalMissedElements) {
            return nums[nums.length - 1] + k - totalMissedElements;
        }

        return findKthMissingElement(nums, k);
    }

    private static int getMissingElementsCount(int[] nums, int i) {
        int num0 = nums[0];
        int num = nums[i];

        int elementsCount = num - num0 + 1;

        return elementsCount - i - 1;
    }

    private static int findKthMissingElement(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int missingElementsCount = getMissingElementsCount(nums, mid);
            if (missingElementsCount < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[right - 1] + k - getMissingElementsCount(nums, right - 1);
    }
}
