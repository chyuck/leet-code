package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/minimum-window-substring/ problem with
 * Time complexity: O(S + T)
 * Space complexity: O(S + T)
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> targetCounts = createTargetCountMap(t);

        return findMinWindow(s, targetCounts, t.length());
    }

    private static Map<Character, Integer> createTargetCountMap(String t) {
        Map<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < t.length(); i++){
            Character c = t.charAt(i);
            Integer count = result.getOrDefault(c, 0);

            result.put(c, count + 1);
        }

        return result;
    }

    private static class Pointers {
        int start;
        int end;

        Pointers(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class Sizes {
        final int target;
        int current;

        Sizes(int target, int current) {
            this.target = target;
            this.current = current;
        }
    }

    private static String findMinWindow(String s, Map<Character, Integer> targetCounts, int targetSize) {
        Pointers result = new Pointers(-1,  s.length());
        Pointers pointers = new Pointers(0, 0);

        Map<Character, Integer> currentCounts = new HashMap<>();
        Sizes sizes = new Sizes(targetSize, 0);

        while (pointers.end < s.length()) {
            moveEndPointer(s, pointers, sizes, currentCounts, targetCounts);
            moveStartPointer(s, pointers, sizes, currentCounts, targetCounts, result);
        }

        return createResult(result, s);
    }

    private static void moveEndPointer(String s, Pointers pointer, Sizes sizes, Map<Character, Integer> currentCounts,
        Map<Character, Integer> targetCounts) {

        while (pointer.end < s.length() && sizes.current < sizes.target) {
            Character c = s.charAt(pointer.end);

            incrementCountsAndSizes(c, sizes, currentCounts, targetCounts);

            pointer.end++;
        }
    }

    private static void incrementCountsAndSizes(Character c, Sizes sizes, Map<Character, Integer> currentCounts,
        Map<Character, Integer> targetCounts) {

        Integer targetCount = targetCounts.getOrDefault(c, 0);
        if (targetCount == 0) {
            return;
        }

        Integer currentCount = currentCounts.getOrDefault(c, 0);
        currentCounts.put(c, currentCount + 1);

        if (currentCount < targetCount) {
            sizes.current++;
        }
    }

    private static void moveStartPointer(String s, Pointers pointer, Sizes sizes, Map<Character, Integer> currentCounts,
        Map<Character, Integer> targetCounts, Pointers result) {

        while (pointer.start < pointer.end && sizes.current == sizes.target) {
            updateResult(pointer, result);

            Character c = s.charAt(pointer.start);
            decrementCountsAndSizes(c, sizes, currentCounts, targetCounts);

            pointer.start++;
        }
    }

    private static void updateResult(Pointers pointer, Pointers result) {
        if (pointer.end - pointer.start > result.end - result.start) {
            return;
        }

        result.start = pointer.start;
        result.end = pointer.end;
    }

    private static void decrementCountsAndSizes(Character c, Sizes sizes, Map<Character, Integer> currentCounts,
        Map<Character, Integer> targetCounts) {

        Integer targetCount = targetCounts.getOrDefault(c, 0);
        if (targetCount == 0) {
            return;
        }

        Integer currentCount = currentCounts.get(c);
        currentCounts.put(c, currentCount - 1);

        if (currentCount <= targetCount) {
            sizes.current--;
        }
    }

    private static String createResult(Pointers result, String s) {
        if (result.start == -1) {
            return "";
        }

        return s.substring(result.start, result.end);
    }
}
