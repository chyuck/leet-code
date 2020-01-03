package solutions;

/**
 * Solutions for https://leetcode.com/problems/climbing-stairs/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        // f(1) = 1 (1)
        // f(2) = 2 (1+1, 2)
        // f(3) = 3 (1+2, 1+1+1, 2+1)
        // f(4) = 5 (1+1+2, 2+2 , 1+2+1, 1+1+1+1, 2+1+1)
        // f(5) = 8
        // f(n) = f(n-2) + f(n-1)

        if (n <= 3) {
            return n;
        }

        int prev_prev = 2;
        int prev = 3;

        for (int i = 4; i <= n; i++) {
            int curr = prev_prev + prev;
            prev_prev = prev;
            prev = curr;
        }

        return prev;
    }
}
