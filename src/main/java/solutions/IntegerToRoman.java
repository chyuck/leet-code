package solutions;

import java.util.Map;
import java.util.TreeMap;

/**
 * Solution for https://leetcode.com/problems/integer-to-roman/ problem with
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        Map<Integer, String> map = createSortedMap();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (num == 0) {
                return result.toString();
            }

            int divider = entry.getKey();
            String roman = entry.getValue();

            int times = num / divider;
            for (int i = 0; i < times; i++) {
                result.append(roman);
            }

            num %= divider;
        }

        return result.toString();
    }

    private static Map<Integer, String> createSortedMap() {
        Map<Integer, String> map = new TreeMap<>((a, b) -> b - a);

        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        return map;
    }
}
