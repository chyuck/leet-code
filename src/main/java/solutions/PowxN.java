package solutions;

/**
 * Solution for https://leetcode.com/problems/powx-n/ problem with
 * Time complexity: O(log(n))
 * Space complexity: O(log(n))
 */
public class PowxN {

    public double myPow(double x, int n) {
        if (x == 1 || n == 0) {
            return 1d;
        }

        if (x == 0) {
            return 0d;
        }

        double result = pow(x, Math.abs((long) n));

        return n > 0 ? result : 1d / result;
    }

    private static double pow(double x, long n) {
        if (n == 0) {
            return 1d;
        }

        double half = pow(x, n / 2);
        double result = half * half;

        return n % 2 == 0 ? result : result * x;
    }
}
