package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/roman-to-integer/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> map = createRomansMap();

        int result = 0;
        int lastValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int value = map.get(c);

            if (value >= lastValue) {
                result += value;
                lastValue = value;
            } else {
                result -= value;
            }
        }

        return result;
    }

    private static Map<Character, Integer> createRomansMap() {
        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        return map;
    }
}
