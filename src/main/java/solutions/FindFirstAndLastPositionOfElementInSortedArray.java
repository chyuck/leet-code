package solutions;

/**
 * Solution for https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/ problem with
 * Time complexity: O(log(n))
 * Space complexity: O(1)
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] { -1,-1 };
        }

        int start = findStart(nums, target);
        if (start == -1) {
            return new int[] { -1,-1 };
        }

        int end = findEnd(nums, start, target);

        return new int[] { start, end };
    }

    private int findStart(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    private int findEnd(int[] nums, int start, int target) {
        int left = start;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }

        throw new RuntimeException();
    }
}