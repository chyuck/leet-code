package solutions;

import org.apache.commons.lang3.text.StrBuilder;

/**
 * Solution for https://leetcode.com/problems/add-strings/ problem with
 * Time complexity: O(max(N1,N2))
 * Space complexity: O(max(N1,N2))
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int carry = 0;

        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >=0) {
            int digit1 = getDigit(num1, i);
            int digit2 = getDigit(num2, j);

            int sum = digit1 + digit2 + carry;
            int newDigit = sum % 10;

            result.insert(0, newDigit);
            carry = sum / 10;

            i--;
            j--;
        }

        if (carry > 0) {
            result.insert(0, carry);
        }

        return result.toString();
    }

    private int getDigit(String number, int index) {
        if (index < 0) {
            return 0;
        }

        char digit = number.charAt(index);

        return Character.getNumericValue(digit);
    }
}
