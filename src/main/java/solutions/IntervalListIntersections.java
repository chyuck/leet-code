package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for https://leetcode.com/problems/interval-list-intersections/ problem with
 * Time complexity: O(A + B)
 * Space complexity: O(A + B)
 */
public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> results = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            int[] interval1 = A[i];
            int[] interval2 = B[j];

            int[] intersection = getIntersection(interval1, interval2);
            if (intersection != null) {
                results.add(intersection);
            }

            if (interval1[1] <= interval2[1]) {
                i++;
            } else {
                j++;
            }
        }

        return results.toArray(new int[results.size()][2]);
    }

    private int[] getIntersection(int[] interval1, int[] interval2) {
        int maxLowerBound = Math.max(interval1[0], interval2[0]);
        int minUpperBound = Math.min(interval1[1], interval2[1]);

        if (maxLowerBound > minUpperBound) {
            return null;
        }

        return new int[] { maxLowerBound, minUpperBound };
    }
}
