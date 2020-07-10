package solutions;

/**
 * Solution for https://leetcode.com/problems/convert-a-number-to-hexadecimal/ problem with
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
public class ConvertANumberToHexadecimal {

    private static final char[] hexDigits =
        new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        while (num != 0) {
            int digit = num & 15;
            char hex = hexDigits[digit];

            result.insert(0, hex);

            num >>>= 4;
        }

        return result.toString();
    }
}
