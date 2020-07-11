package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/find-all-anagrams-in-a-string/ problem with
 * Time complexity: O(S + P)
 * Space complexity: O(1)
 */
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || p.length() > s.length()) {
            return Collections.emptyList();
        }

        Map<Character, Integer> targetCounts = createTargetCountsMap(p);

        return findAnagramIndexes(s, targetCounts, p.length());
    }

    private static Map<Character, Integer> createTargetCountsMap(String p) {
        Map<Character, Integer> results = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            Character c = p.charAt(i);
            Integer count = results.getOrDefault(c, 0);
            results.put(c, count + 1);
        }

        return results;
    }

    private static class Sizes {
        final int target;
        int current;

        Sizes(int target, int current) {
            this.target = target;
            this.current = current;
        }
    }

    private static List<Integer> findAnagramIndexes(String s, Map<Character, Integer> targetCounts, int targetSize) {
        List<Integer> results = new ArrayList<>();

        Sizes sizes = new Sizes(targetSize, 0);
        Map<Character, Integer> currentCounts = createCurrentTargetMap(s, targetCounts, sizes);

        if (sizes.current == sizes.target) {
            results.add(0);
        }

        int maxStartIndex = s.length() - targetSize;

        for (int startIndex = 0; startIndex < maxStartIndex; startIndex++) {
            removeChar(s.charAt(startIndex), currentCounts, targetCounts, sizes);
            addChar(s.charAt(startIndex + targetSize), currentCounts, targetCounts, sizes);

            if (sizes.current == sizes.target) {
                results.add(startIndex + 1);
            }
        }

        return results;
    }

    private static Map<Character, Integer> createCurrentTargetMap(String s, Map<Character, Integer> targetCounts, Sizes sizes) {
        Map<Character, Integer> results = new HashMap<>();

        for (int i = 0; i < sizes.target; i++) {
            addChar(s.charAt(i), results, targetCounts, sizes);
        }

        return results;
    }

    private static void removeChar(char c, Map<Character, Integer> currentCounts, Map<Character, Integer> targetCounts, Sizes sizes) {
        Integer targetCount = targetCounts.get(c);
        if (targetCount == null) {
            return;
        }

        Integer currentCount = currentCounts.get(c);

        if (currentCount <= targetCount) {
            sizes.current--;
        }

        currentCounts.put(c, currentCount - 1);
    }

    private static void addChar(char c, Map<Character, Integer> currentCounts, Map<Character, Integer> targetCounts, Sizes sizes) {
        Integer targetCount = targetCounts.get(c);
        if (targetCount == null) {
            return;
        }

        Integer currentCount = currentCounts.getOrDefault(c, 0);

        if (currentCount < targetCount) {
            sizes.current++;
        }

        currentCounts.put(c, currentCount + 1);
    }
}
