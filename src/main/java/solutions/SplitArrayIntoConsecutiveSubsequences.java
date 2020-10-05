package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/split-array-into-consecutive-subsequences/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class SplitArrayIntoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> numCounts = new HashMap<>();
        for (int num : nums) {
            Integer numCount = numCounts.getOrDefault(num, 0);
            numCounts.put(num, numCount + 1);
        }

        Map<Integer, Integer> tailCounts = new HashMap<>();

        for (int num : nums) {

            Integer numCount = numCounts.getOrDefault(num, 0);
            if (numCount == 0) {
                continue;
            }

            numCounts.put(num, numCount - 1);

            Integer tailCount = tailCounts.getOrDefault(num, 0);
            if (tailCount > 0) {
                tailCounts.put(num, tailCount - 1);

                Integer nextTailCount = tailCounts.getOrDefault(num + 1, 0);
                tailCounts.put(num + 1, nextTailCount + 1);
                continue;
            }

            Integer nextNumCount = numCounts.getOrDefault(num + 1, 0);
            Integer nextNextNumCount = numCounts.getOrDefault(num + 2, 0);
            boolean containsThreeConsecutive = nextNumCount > 0 && nextNextNumCount > 0;
            if (!containsThreeConsecutive) {
                return false;
            }

            numCounts.put(num + 1, nextNumCount - 1);
            numCounts.put(num + 2, nextNextNumCount - 1);

            Integer nextNextNextTailCount = tailCounts.getOrDefault(num + 3, 0);
            tailCounts.put(num + 3, nextNextNextTailCount + 1);
        }

        return true;
    }
}
