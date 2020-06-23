package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/continuous-subarray-sum/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        // for k=1 and k=-1
        if (Math.abs(k) == 1) {
            return true;
        }

        // for nums=[..0,0..]
        boolean hasZeros = checkSubarraySumForZeros(nums);
        if (hasZeros) {
            return true;
        }

        // for no nums=[..0,0..], and k=0
        if (k == 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            int reminder = sum % k;

            Integer index = map.get(reminder);
            if (index != null) {
                if (i - index > 1) {
                    return true;
                }

                continue;
            }
            map.put(reminder, i);
        }

        return false;
    }

    private boolean checkSubarraySumForZeros(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0 && nums[i - 1] == 0) {
                return true;
            }
        }

        return false;
    }
}