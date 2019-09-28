package solutions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Solution for https://leetcode.com/problems/merge-intervals/ problem with
 * Time complexity: O(n * log(n))
 * Space complexity: O(n)
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> results = new ArrayList<>();
        int[] current = intervals[0];
        results.add(current);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (interval[0] <= current[1]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                current = interval;
                results.add(interval);
            }
        }

        return results.toArray(new int[][] {});
    }
}
