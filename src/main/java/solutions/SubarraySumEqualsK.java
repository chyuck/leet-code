package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/subarray-sum-equals-k/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;

        for (int num : nums) {
            sum += num;

            Integer count = map.get(sum - k);
            if (count != null) {
                result += count;
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
