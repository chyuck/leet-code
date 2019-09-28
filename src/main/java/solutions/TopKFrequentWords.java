package solutions;

import java.util.*;

/**
 * Solution for https://leetcode.com/problems/top-k-frequent-words/ problem with
 * Time complexity: O(n * log(k))
 * Space complexity: O(n)
 */
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> counts = new HashMap<>();
        for (String word: words) {
            Integer count = counts.getOrDefault(word,0);
            counts.put(word, count + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            Integer countA = counts.get(a);
            Integer countB = counts.get(b);

            if (countA == countB)
                return b.compareTo(a);

            return countA - countB;
        });
        for (String key: counts.keySet()) {
            minHeap.add(key);
            if (minHeap.size() > k)
                minHeap.remove();
        }

        LinkedList<String> result = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            String word = minHeap.remove();
            result.addFirst(word);
        }

        return result;
    }
}
