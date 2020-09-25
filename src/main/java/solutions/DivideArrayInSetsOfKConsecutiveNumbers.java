package solutions;

import java.util.TreeMap;

/**
 * Solution for https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/ problem with
 * Time complexity: O(n * log(n))
 * Space complexity: O(n)
 */
public class DivideArrayInSetsOfKConsecutiveNumbers {

    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> orderedNums = new TreeMap<>();
        for (int num : nums) {
            Integer count = orderedNums.getOrDefault(num, 0);
            orderedNums.put(num, count + 1);
        }

        while (!orderedNums.isEmpty()) {
            Integer firstNum = orderedNums.firstKey();

            for (Integer num = firstNum; num < firstNum + k; num++) {
                Integer count = orderedNums.get(num);
                if (count == null) {
                    return false;
                }

                if (count == 1) {
                    orderedNums.remove(num);
                } else {
                    orderedNums.put(num, count - 1);
                }
            }
         }

        return true;
    }
}
