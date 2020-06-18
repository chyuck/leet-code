package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/partition-equal-subset-sum/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % 2 == 1) {
            return false;
        }

        return canPartition(nums, totalSum, 0, 0, new HashMap<>());
    }

    private static boolean canPartition(int[] nums, int totalSum, int index, int sum,
        Map<String, Boolean> cache) {

        String cacheKey = index + "-" + sum;
        Boolean cacheResult = cache.get(cacheKey);
        if (cacheResult != null) {
            return cacheResult;
        }

        if (sum * 2 == totalSum) {
            return true;
        }

        if (sum * 2 > totalSum) {
            return false;
        }

        if (index >= nums.length) {
            return false;
        }

        int num = nums[index];

        boolean result = canPartition(nums, totalSum, index + 1, sum, cache)
            || canPartition(nums, totalSum, index + 1, sum + num, cache);

        cache.put(cacheKey, result);

        return result;
    }
}
