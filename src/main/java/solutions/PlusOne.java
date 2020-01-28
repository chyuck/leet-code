package solutions;

/**
 * Solutions for https://leetcode.com/problems/plus-one/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (isAllNines(digits)) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        } else {
            int[] result = new int[digits.length];

            int carry = 1;

            for (int i = digits.length - 1; i >= 0; i--) {
                int digit = digits[i];
                int newDigit = digit + carry;

                result[i] = newDigit == 10 ? 0 : newDigit;
                carry = newDigit == 10 ? 1 : 0;
            }

            return result;
        }
    }

    private static boolean isAllNines(int[] digits) {
        for (int digit : digits) {
            if (digit != 9) {
                return false;
            }
        }

        return true;
    }
}
