package solutions;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Solution for https://leetcode.com/problems/sliding-window-maximum problem with
 */
public class SlidingWindowMaximum {

    /**
     * Time complexity: amortized O(N)
     * Space complexity: O(k)
     * where N - length of numbers
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= 1) return nums;
        if (k == 1) return nums;

        // linked list to keep indexes that have the following properties:
        // - Indexes are ordered by index and by number from left to right
        // - No indexes that out of window
        // - No indexes of numbers that less than new incoming number, which means that index of max number within window always at the left
        LinkedList<Integer> linkedList = new LinkedList<>();

        // result array
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            // index of result array to populate
            int resultIndex = i - k + 1;

            // clear all indexes that out of window
            while (!linkedList.isEmpty() && linkedList.getFirst() < resultIndex) {
                linkedList.removeFirst();
            }

            // clear all indexes of elements that less than new element, to maintain index for max element at the left
            while (!linkedList.isEmpty() && nums[linkedList.getLast()] < nums[i]) {
                linkedList.removeLast();
            }

            // add new element
            linkedList.addLast(i);

            // populate result array with max number
            if (resultIndex >= 0) {
                int maxWindowNumIndex = linkedList.getFirst();
                result[resultIndex] = nums[maxWindowNumIndex];
            }

        }

        return result;
    }

    /**
     * Time complexity: O(N * log(k))
     * Space complexity: O(k)
     * where N - length of numbers
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length <= 1) return nums;
        if (k == 1) return nums;

        // create max heap and add first 'k' elements
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            maxQueue.add(nums[i]);
        }

        // create result array and populate the first result
        int[] result = new int[nums.length - k + 1];
        result[0] = maxQueue.peek();

        for (int i = 1; i < result.length; i++) {
            // remove number which out of window
            maxQueue.remove(nums[i - 1]);
            // add new number
            maxQueue.add(nums[i + k - 1]);
            // set max number to result array
            result[i] = maxQueue.peek();
        }

        return result;
    }
}
