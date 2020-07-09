package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution for https://leetcode.com/problems/merge-intervals/ problem with
 * Time complexity: O(n * log(n))
 * Space complexity: O(n)
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> results = new ArrayList<>();

        int[] lastInterval = new int[] { intervals[0][0], intervals[0][1] };
        results.add(lastInterval);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (lastInterval[1] >= interval[0]) {
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            } else {
                lastInterval = new int[] { interval[0], interval[1] };
                results.add(lastInterval);
            }
        }

        return results.toArray(new int[results.size()][2]);
    }
}
