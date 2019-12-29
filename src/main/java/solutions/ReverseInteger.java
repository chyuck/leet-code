package solutions;

/**
 * Solution for https://leetcode.com/problems/reverse-integer/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 * where n - number of digits
 */
public class ReverseInteger {

    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1;
        x *= sign;

        int reversed = 0;

        while (x > 0) {

            // check overflow case
            if (x < 10) {
                int maxWithoutLastDigit = Integer.MAX_VALUE / 10;
                int maxLastDigit = Integer.MAX_VALUE % 10;

                if (maxWithoutLastDigit < reversed) {
                    return 0;
                }
                if (maxWithoutLastDigit == reversed && maxLastDigit < x) {
                    return 0;
                }
            }

            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return sign * reversed;
    }
}