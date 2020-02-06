package solutions;

/**
 * Solutions for https://leetcode.com/problems/sum-of-two-integers/ problem with
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
public class SumOfTwoIntegers {

    public int getSum(int a, int b) {

        while (b != 0) {
            int sum = a ^ b;
            int carry = a & b;

            a = sum;
            b = carry << 1;
        }

        return a;
    }
}
