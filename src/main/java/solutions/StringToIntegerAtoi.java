package solutions;

/**
 * Solutions for https://leetcode.com/problems/string-to-integer-atoi/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 * where n - length of input string
 */
public class StringToIntegerAtoi {

    public int myAtoi(String str) {
        // if input string is empty, return 0
        if (str == null || str.isEmpty())
            return 0;

        // save input string size
        int n = str.length();

        // skip spaces
        int index = 0;
        while (index < n && str.charAt(index) == ' ') {
            index++;
        }

        // reached the end of string, return 0
        if (index == n)
            return 0;

        // calculate sign
        int sign = str.charAt(index) == '-' ? -1 : 1;

        // move to next char if sign is present
        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            index++;
        }

        // reached the end of string, return 0
        if (index == n)
            return 0;

        // calculate max value without last digit
        // -2,147,483,647 -> -2,147,483,64
        int max = Integer.MAX_VALUE / 10;
        // calculate last digit
        // 2,147,483,647 -> 7 or -2,147,483,648 -> 8
        int lastMaxDigit = sign > 0 ? Integer.MAX_VALUE - max * 10 : -(Integer.MIN_VALUE + max * 10);

        // result without sign
        int number = 0;
        // loop until end or until character is digit
        while (index < n && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            // convert character to digit
            int digit = str.charAt(index) - '0';
            // if number is greater than max without last digit
            // or number is equal max without last digit but last digit is greater then max last digit
            // return integer max or min, depend on sign
            if (number > max || number == max && digit >= lastMaxDigit) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // accumulate current digit to result
            number = number * 10 + digit;
            // move to next character
            index++;
        }

        // add sign to number and return result
        return sign * number;
    }
}
