package solutions;

/**
 * Solution for https://leetcode.com/problems/basic-calculator-ii/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class BasicCalculator2 {

    public int calculate(String s) {
        int result = 0;

        int number = 0;

        char lastSign = '+';
        int subResult = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int digit = c - '0';
                number = number * 10 + digit;
            }

            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
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

                lastSign = c;
                number = 0;
            }
        }

        result += subResult;

        return result;
    }
}
