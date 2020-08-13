package solutions;

/**
 * Solution for https://leetcode.com/problems/monotonic-array/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MonotonicArray {

    public boolean isMonotonic(int[] A) {
        Boolean increasing = null;

        for (int i = 1; i < A.length; i++) {
            int a1 = A[i - 1];
            int a2 = A[i];

            if (a1 > a2) {
                if (increasing != null && increasing) {
                    return false;
                }
                increasing = false;
            } else if (a1 < a2) {
                if (increasing != null && !increasing) {
                    return false;
                }
                increasing = true;
            }
        }

        return true;
    }
}
