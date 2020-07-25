package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/custom-sort-string/ problem with
 * Time complexity: O(S + T)
 * Space complexity: O(T)
 */
public class CustomSortString {

    public String customSortString(String S, String T) {
        if (S == null || S.length() == 0 || T == null || T.length() == 0) {
            return T;
        }

        Map<Character, Integer> tCounts = buildCounts(T);

        StringBuilder result = new StringBuilder();

        addCharactersThatExistInS(S, result, tCounts);

        addCharactersThatDoNotExistInS(result, tCounts);

        return result.toString();
    }


    private static Map<Character, Integer> buildCounts(String t) {
        Map<Character, Integer> results = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer count = results.getOrDefault(c, 0);
            results.put(c, count + 1);
        }

        return results;
    }

    private void addCharactersThatExistInS(String s, StringBuilder result, Map<Character, Integer> tCounts) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            Integer count = tCounts.get(c);
            if (count == null) {
                continue;
            }

            for (int j = 0; j < count; j++) {
                result.append(c);
            }

            tCounts.remove(c);
        }
    }

    private void addCharactersThatDoNotExistInS(StringBuilder result, Map<Character, Integer> tCounts) {
        for (Map.Entry<Character, Integer> tCount : tCounts.entrySet()) {
            char c = tCount.getKey();
            int count = tCount.getValue();

            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }
    }
}
