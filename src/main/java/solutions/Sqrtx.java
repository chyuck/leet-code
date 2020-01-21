package solutions;

/**
 * Solution for https://leetcode.com/problems/sqrtx/ problem with
 * Time complexity: O(log(n))
 * Space complexity: O(1)
 */
public class Sqrtx {

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int lower = 2;
        int upper = x / 2;

        while (lower <= upper) {
            int distance = upper - lower;
            int middle = lower + distance / 2;

            long square = (long)middle * (long)middle;

            if (square < x) {
                lower = middle + 1;
            } else if (square > x) {
                upper = middle - 1;
            } else {
                return middle;
            }
        }

        return upper;
    }
}
