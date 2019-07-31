package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Solutions for https://leetcode.com/problems/subsets problem with
 * Time complexity: O(2^n)
 * Space complexity: O(2^n)
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        // create result list and add empty result
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());

        // if input is empty, return result
        if (nums == null || nums.length == 0) {
            return results;
        }

        // Implementation has the following iterations if input is [1,2,3]
        // 1: [] (empty result)
        // 2: [],[3] (add 3 to all previous results)
        // 3: [],[3],[2],[2,3] (add 2 to all previous results)
        // 4: [],[3],[2],[2,3],[1],[1,3],[1,2],[1,2,3] (add 1 to all previous results)

        // start looping from end to beginning
        for (int i = nums.length - 1; i >= 0; i--) {
            // create temp results
            List<List<Integer>> newResults = new ArrayList<>();

            // iterate all previous results and add current number to all results
            // save new results to temp results
            for (List<Integer> subResult: results) {
                List<Integer> newResult = new ArrayList<>();
                newResult.add(nums[i]);
                newResult.addAll(subResult);
                newResults.add(newResult);
            }

            // move temp results to permanent results
            results.addAll(newResults);
        }

        return results;
    }
}
