package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution for https://leetcode.com/problems/contains-duplicate/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Set<Integer> visited = new HashSet<>();

        for (int num : nums) {
            if (visited.contains(num)) {
                return true;
            }

            visited.add(num);
        }

        return false;
    }
}
