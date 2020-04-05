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
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> targetChars = new HashMap<>();
        Map<Character, Integer> currentChars = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            Integer count = targetChars.getOrDefault(ch, 0) + 1;

            targetChars.put(ch, count);
            currentChars.put(ch, 0);
        }

        int targetCount = t.length(), currentCount = 0;

        int start = 0, end = 0;
        int resultStart = -1, resultEnd = -1;

        while (end < s.length()) {
            while (end < s.length() && currentCount < targetCount) {
                Character curr = s.charAt(end);

                if (targetChars.containsKey(curr)) {
                    if (currentChars.get(curr) < targetChars.get(curr)) {
                        currentCount++;
                    }

                    currentChars.put(curr, currentChars.get(curr) + 1);
                }

                end++;
            }

            while (currentCount == targetCount) {
                Character curr = s.charAt(start);

                if (resultStart == -1 || end - start < resultEnd - resultStart) {
                    resultStart = start;
                    resultEnd = end;
                }

                if (targetChars.containsKey(curr)) {
                    if (currentChars.get(curr) <= targetChars.get(curr)) {
                        currentCount--;
                    }

                    currentChars.put(curr, currentChars.get(curr) - 1);
                }

                start++;
            }
        }

        return resultStart != -1 ? s.substring(resultStart, resultEnd) : "";
    }
}
