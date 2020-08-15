package solutions;

/**
 * Solution for https://leetcode.com/problems/decode-string/ problem with
 * Time complexity: O(n * k)
 * Space complexity: O(n * k)
 * k - number of times string repeated
 */
public class DecodeString {

    public String decodeString(String s) {
        int[] index = new int[] { 0 };

        return decodeString(s, index);
    }

    private static String decodeString(String s, int[] index) {
        StringBuilder result = new StringBuilder();

        while (index[0] < s.length() && s.charAt(index[0]) != ']') {
            char c = s.charAt(index[0]);

            if (Character.isDigit(c)) {
                int number = 0;
                while (s.charAt(index[0]) != '[') {
                    int digit = s.charAt(index[0]) - '0';
                    number = number * 10 + digit;
                    index[0]++;
                }

                index[0]++;
                String repeatedString = decodeString(s, index);

                for (int i = 0; i < number; i++) {
                    result.append(repeatedString);
                }
                index[0]++;

            } else {
                result.append(c);
                index[0]++;
            }
        }

        return result.toString();
    }
}
