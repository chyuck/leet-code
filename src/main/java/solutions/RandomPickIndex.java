package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Solution for https://leetcode.com/problems/random-pick-index/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class RandomPickIndex {

    private final Map<Integer, ArrayList<Integer>> map;

    public RandomPickIndex(int[] nums) {
        map = createHashMap(nums);
    }

    private Map<Integer, ArrayList<Integer>> createHashMap(int[] nums) {
        Map<Integer, ArrayList<Integer>> results = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            ArrayList<Integer> existingIndexes = results.get(num);
            ArrayList<Integer> indexes = existingIndexes != null ? existingIndexes : new ArrayList<>();
            indexes.add(i);
            results.put(num, indexes);
        }

        return results;
    }

    private final Random random = new Random();

    public int pick(int target) {
        ArrayList<Integer> indexes = map.get(target);

        int i = random.nextInt(indexes.size());

        return indexes.get(i);
    }
}
