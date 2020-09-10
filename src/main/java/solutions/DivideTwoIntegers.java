package solutions;

/**
 * Solution for https://leetcode.com/problems/divide-two-integers/ problem with
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isResultPositive = (dividend >= 0) == (divisor >= 0);

        int a = Math.abs(dividend);
        int b = Math.abs(divisor);

        int result = 0;

        for (int power = 31; power >= 0; power--) {
            if ((a >>> power) - b >= 0) {
                int subResult = b << power;
                a -= subResult;

                int powerOfTwo = 1 << power;
                result += powerOfTwo;
            }
        }

        return isResultPositive ? result : -result;
    }
}
