package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/group-shifted-strings/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 * where n - number of all characters in all strings
 */
public class GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> groups = createGroups(strings);

        return new ArrayList<>(groups.values());
    }

    private static Map<String, List<String>> createGroups(String[] strings) {
        Map<String, List<String>> results = new HashMap<>();

        for (String s : strings) {
            String shiftedToA = shiftToA(s);

            List<String> existingResult = results.get(shiftedToA);
            List<String> result = existingResult != null ? existingResult : new ArrayList<>();

            result.add(s);
            results.put(shiftedToA, result);
        }

        return results;
    }

    private static String shiftToA(String s) {
        StringBuilder result = new StringBuilder();

        int shiftFromA = getShiftFromA(s.charAt(0));
        if (shiftFromA == 0) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char shiftedLeft = shiftLeft(c, shiftFromA);

            result.append(shiftedLeft);
        }

        return result.toString();
    }

    private static int getShiftFromA(char c) {
        return c - 'a';
    }

    private static char shiftLeft(char c, int shift) {
        int shiftFromA = getShiftFromA(c);

        if (shift == shiftFromA) {
            return 'a';
        } else if (shift < shiftFromA) {
            return (char) (c - shift);
        } else {
            return (char) ('z' - (shift - shiftFromA) + 1);
        }
    }
}
