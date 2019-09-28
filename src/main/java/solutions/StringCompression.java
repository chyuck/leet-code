package solutions;

/**
 * Solution for https://leetcode.com/problems/string-compression/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class StringCompression {

    public int compress(char[] chars) {
        if (chars.length <= 1) return chars.length;

        int count = 1, index = 0;
        char lastChar = chars[0];

        for (int i = 1; i < chars.length; i++) {
            char ch = chars[i];

            if (ch == lastChar) {
                count++;
            } else {
                index = updateChars(chars, index, lastChar, count);

                lastChar = ch;
                count = 1;
            }
        }

        return updateChars(chars, index, lastChar, count);
    }

    private int updateChars(char[] chars, int index, char lastChar, int count) {
        chars[index++] = lastChar;
        for (char c: toChars(count))
            chars[index++] = c;

        return index;
    }

    private char[] toChars(Integer number) {
        if (number == 1) return new char[] {};

        return number.toString().toCharArray();
    }
}
