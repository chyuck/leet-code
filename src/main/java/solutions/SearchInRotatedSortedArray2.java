package solutions;

/**
 * Solution for https://leetcode.com/problems/search-in-rotated-sorted-array-ii/ problem with
 * Time complexity: O(log(n))
 * Space complexity: O(1)
 */
public class SearchInRotatedSortedArray2 {

    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] < nums[end]) {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] > nums[end]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                end--;
            }
        }

        return false;
    }
}
