package solutions;

import java.util.LinkedList;

/**
 * Solution for https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class LongestContinuousSubarrayWithDiffUpToLimit {

    public int longestSubarray(int[] nums, int limit) {
        LinkedList<Integer> minNums = new LinkedList<>(), maxNums = new LinkedList<>();

        int result = 0;

        int left = 0, right = 0;

        while (right < nums.length) {
            while (!minNums.isEmpty() && minNums.getLast() > nums[right]) {
                minNums.removeLast();
            }
            minNums.addLast(nums[right]);

            while (!maxNums.isEmpty() && maxNums.getLast() < nums[right]) {
                maxNums.removeLast();
            }
            maxNums.addLast(nums[right]);

            while (maxNums.getFirst() - minNums.getFirst() > limit) {
                if (minNums.getFirst() == nums[left]) {
                    minNums.removeFirst();
                }

                if (maxNums.getFirst() == nums[left]) {
                    maxNums.removeFirst();
                }

                left++;
            }

            result = Math.max(result, right - left + 1);

            right++;
        }

        return result;
    }
}
