package solutions;

import java.util.HashMap;

public class TwoSum {

    /**
     * Solution for https://leetcode.com/problems/two-sum problem with
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsToIndexes = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            int num2 = target - num1;

            if (numsToIndexes.containsKey(num2))
                return new int[] { numsToIndexes.get(num2), i };

            numsToIndexes.put(num1, i);
        }

        throw new IllegalArgumentException("No solution.");
    }
}