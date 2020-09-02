package solutions;

/**
 * Solution for https://leetcode.com/problems/basic-calculator/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class BasicCalculator {

    public int calculate(String s) {
        String expressionWithoutSpaces = removeSpaces(s);

        return calculate(expressionWithoutSpaces, new int[] { 0 });
    }

    private static String removeSpaces(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c != ' ') {
                result.append(c);
            }
        }

        return result.toString();
    }

    private static int calculate(String exp, int[] index) {
        int result = 0;

        int sign = 1;

        while (index[0] < exp.length()) {
            char c = exp.charAt(index[0]);

            if (Character.isDigit(c)) {
                int number = getNumber(exp, index);
                result += sign * number;
            } else if (c == '+') {
                sign = 1;
                index[0]++;
            } else if (c == '-') {
                sign = -1;
                index[0]++;
            } else if (c == '(') {
                index[0]++;
                result += sign * calculate(exp, index);
            } else if (c == ')') {
                index[0]++;
                return result;
            }
        }

        return result;
    }

    private static int getNumber(String exp, int[] index) {
        int number = 0;
        while (index[0] < exp.length() && Character.isDigit(exp.charAt(index[0]))) {
            int digit = exp.charAt(index[0]) - '0';
            number = number * 10 + digit;
            index[0]++;
        }

        return number;
    }
}
