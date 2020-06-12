package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/find-all-anagrams-in-a-string/ problem with
 * Time complexity: O(S+P)
 * Space complexity: O(1)
 */
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> results = new ArrayList<>();

        int sn = s.length(), pn = p.length();
        if (pn > sn) {
            return results;
        }

        Map<Character, Integer> sCount = new HashMap<>(pn);
        Map<Character, Integer> pCount = new HashMap<>(pn);

        for (Character c : p.toCharArray()) {
            pCount.put(c, pCount.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < sn; i++) {
            Character c = s.charAt(i);

            if (pCount.containsKey(c)) {
                sCount.put(c, sCount.getOrDefault(c, 0) + 1);
            }

            if (i >= pn) {
                Character firstChar = s.charAt(i - pn);
                Integer count = sCount.get(firstChar);
                if (count != null) {
                    if (count.equals(1)) {
                        sCount.remove(firstChar);
                    } else {
                        sCount.put(firstChar, count - 1);
                    }
                }
            }

            if (sCount.equals(pCount)) {
                results.add(i - pn + 1);
            }
        }

        return results;
    }
}
