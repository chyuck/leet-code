package solutions;

/**
 * Solution for https://leetcode.com/problems/basic-calculator-iii/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class BasicCalculator3 {

    public int calculate(String s) {
        return calculate(s, new int[] { 0 });
    }

    private static int calculate(String s, int[] index) {
        int result = 0;

        int number = 0;

        char lastSign = '+';
        int subResult = 0;

        while (index[0] < s.length()) {
            char c = s.charAt(index[0]);

            if (Character.isDigit(c)) {
                int digit = c - '0';
                number = number * 10 + digit;

            } else if (c == '(') {
                index[0]++;
                number = calculate(s, index);
            }

            if (c == '+' || c == '-' || c == '*' || c == '/' || c == ')' || index[0] == s.length() - 1) {
                switch (lastSign) {
                    case '+':
                        result += subResult;
                        subResult = number;
                        break;
                    case '-':
                        result += subResult;
                        subResult = -number;
                        break;
                    case '*':
                        subResult *= number;
                        break;
                    case '/':
                        subResult /= number;
                        break;
                }

                if (c == ')') {
                    break;
                }

                lastSign = c;
                number = 0;
            }

            index[0]++;
        }

        result += subResult;

        return result;
    }
}
