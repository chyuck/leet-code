package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Solution for https://leetcode.com/problems/top-k-frequent-elements/ problem with
 * Time complexity: O(n * log(k))
 * Space complexity: O(n + k)
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            Integer count = counts.getOrDefault(num, 0);
            counts.put(num, count + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        int[] results = new int[pq.size()];
        for (int i = 0; i < results.length; i++) {
            results[i] = pq.remove().getKey();
        }

        return results;
    }
}
