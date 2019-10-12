package solutions;

import java.util.*;

/**
 * Solution for https://leetcode.com/problems/top-k-frequent-words/ problem with
 * Time complexity: O(n * log(k))
 * Space complexity: O(n)
 */
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> counts = new HashMap<>();
        for (String word: words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            Integer countA = counts.get(a), countB = counts.get(b);

            if (countA != countB)
                return countA - countB;

            return b.compareTo(a);
        });

        for (String word: counts.keySet()) {

            minHeap.add(word);

            if (minHeap.size() > k)
                minHeap.remove();
        }

        LinkedList<String> result = new LinkedList<>();

        while (minHeap.size() > 0) {
            result.addFirst(minHeap.remove());
        }

        return result;
    }
}
