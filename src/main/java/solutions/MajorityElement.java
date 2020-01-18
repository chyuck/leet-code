package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/majority-element/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        int half = nums.length / 2;

        for (int num : nums) {
            Integer count = counts.getOrDefault(num, 0);
            if (count + 1 > half) {
                return num;
            }

            counts.put(num, count + 1);
        }

        throw new IllegalArgumentException();
    }
}
