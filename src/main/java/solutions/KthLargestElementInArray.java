package solutions;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Solution for https://leetcode.com/problems/kth-largest-element-in-an-array problem
 */
public class KthLargestElementInArray {

    /**
     * Solution from https://en.wikipedia.org/wiki/Quickselect with
     * Time complexity: O(n) in average case
     * Space complexity: O(1)
     */
    public int findKthLargest(int[] nums, int k) {
        return select(nums, 0, nums.length - 1, k);
    }

    private final Random random = new Random();

    private int select(int[] nums, int left, int right, int k) {
        // if contains only one element, return it
        if (left == right) return nums[left];

        // generate random pivot index
        int pivotIndex = left + random.nextInt(right - left + 1);
        // partition elements around random pivot number
        int newPivotIndex = partition(nums, left, right, pivotIndex);

        int rightElementsLength = nums.length - newPivotIndex;

        // if new pivot number is k-th largest, return it
        if (rightElementsLength == k)
            return nums[newPivotIndex];

        // if k-th largest number on right
        if (rightElementsLength > k)
            return select(nums, newPivotIndex + 1, right, k);

        // if k-th largest number on left
        return select(nums, left, newPivotIndex - 1, k);
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        // record pivot number
        int pivotNumber = nums[pivotIndex];

        // move pivot number to the end
        swap(nums, pivotIndex, right);

        // index for pivot number
        // at the left side all numbers are less than pivot number
        // at the right side all numbers are greater than pivot number
        int result = left;
        // loop from left to right
        for (int i = left; i < right; i++) {
            // if number is less that pivot number
            // then move it to the left side of result index for pivot number
            if (nums[i] < pivotNumber) {
                swap(nums, result, i);
                result++;
            }
        }

        // move pivot number to result index for pivot number
        swap(nums, result, right);

        // return new pivot index based on partitioning
        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Min heap solution with
     * Time complexity: O(n * log(k))
     * Space complexity: O(k)
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (queue.size() < k) {
                queue.add(num);
                continue;
            }

            if (num > queue.peek()) {
                queue.remove();
                queue.add(num);
                continue;
            }
        }

        return queue.peek();
    }
}
