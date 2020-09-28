package solutions;

/**
 * Solution for https://leetcode.com/problems/rle-iterator/ problem with
 * Time complexity: O(n + m)
 * Space complexity: O(n)
 * where n - number of elements in A, m - number of "next" calls
 */
public class RLEIterator {

    private final int[] A;
    private int index = 0;
    private int count = 0;

    public RLEIterator(int[] A) {
        this.A = A;
    }

    public int next(int n) {
        while (index < A.length) {
            int totalCount = A[index];
            int countLeft = totalCount - count;

            if (countLeft < n) {
                n -= countLeft;
                index += 2;
                count = 0;
            } else {
                count += n;
                int value = A[index + 1];
                return value;
            }
        }

        return -1;
    }
}
