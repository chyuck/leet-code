package solutions;

/**
 * Solutions for https://leetcode.com/problems/reverse-bits/ problem with
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
public class ReverseBits {

    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int bit = n & (1 << i);
            result ^= (bit >>> i) << (31 - i);
        }

        return result;
    }
}
