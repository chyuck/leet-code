package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution for https://leetcode.com/problems/reorganize-string/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ReorganizeString {

    public String reorganizeString(String S) {
        if (S.length() == 1) {
            return S;
        }

        Map<Character, Integer> counts = getCounts(S);

        boolean solutionExists = canReorganize(counts, S.length());
        if (!solutionExists) {
            return "";
        }

        Queue<CharCount> priorityQueue = createPriorityQueue(counts);

        return buildResult(priorityQueue);
    }

    private Map<Character, Integer> getCounts(String s) {
        Map<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = result.getOrDefault(c, 0);
            result.put(c, count + 1);
        }

        return result;
    }

    private boolean canReorganize(Map<Character, Integer> counts, int length) {
        int maxCount = (length + 1) / 2;

        for (Integer count : counts.values()) {
            if (count > maxCount) {
                return false;
            }
        }

        return true;
    }

    private static class CharCount {
        final char character;
        int count;

        private CharCount(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }

    private Queue<CharCount> createPriorityQueue(Map<Character, Integer> counts) {
        Queue<CharCount> result = new PriorityQueue<>((a, b) -> {
           // higher count first
           if (a.count != b.count) {
               return b.count - a.count;
           }

           // in alphabetical order
           return a.character - b.character;
        });

        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            CharCount charCount = new CharCount(entry.getKey(), entry.getValue());
            result.add(charCount);
        }

        return result;
    }

    private String buildResult(Queue<CharCount> priorityQueue) {
        StringBuilder result = new StringBuilder();

        while (priorityQueue.size() > 1) {
            CharCount charCount1 = priorityQueue.remove();
            CharCount charCount2 = priorityQueue.remove();

            result.append(charCount1.character);
            result.append(charCount2.character);

            if (charCount1.count > 1) {
                charCount1.count--;
                priorityQueue.add(charCount1);
            }
            if (charCount2.count > 1) {
                charCount2.count--;
                priorityQueue.add(charCount2);
            }
        }

        // last character
        if (!priorityQueue.isEmpty()) {
            CharCount charCount = priorityQueue.remove();
            result.append(charCount.character);
        }

        return result.toString();
    }
}
