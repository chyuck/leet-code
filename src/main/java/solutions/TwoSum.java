package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/two-sum problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int second = nums[i];
            int first = target - second;

            if (map.containsKey(first)) {
                return new int[] { map.get(first), i };
            }

            map.put(second, i);
        }

        throw new IllegalStateException("No solution");
    }
}