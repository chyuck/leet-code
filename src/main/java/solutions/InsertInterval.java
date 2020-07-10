package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for https://leetcode.com/problems/insert-interval/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null) {
            return intervals;
        }

        if (intervals == null || intervals.length == 0) {
            return new int[][] { newInterval };
        }

        List<int[]> allIntervals = insertIntervalWithoutMerge(intervals, newInterval);

        List<int[]> results = mergeIntervals(allIntervals);

        return results.toArray(new int[results.size()][2]);
    }

    private static List<int[]> insertIntervalWithoutMerge(int[][] intervals, int[] newInterval) {
        List<int[]> results = new ArrayList<>();

        int lastStart = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            if (lastStart <= newInterval[0] && newInterval[0] <= interval[0]) {
                results.add(newInterval);
            }

            results.add(interval);

            lastStart = interval[0];
        }

        if (intervals.length == results.size()) {
            results.add(newInterval);
        }

        return results;
    }

    private static List<int[]> mergeIntervals(List<int[]> intervals) {
        List<int[]> results = new ArrayList<>();

        int[] firstInterval = intervals.get(0);
        int[] lastInterval = new int[] { firstInterval[0], firstInterval[1] };
        results.add(lastInterval);

        for (int i = 1; i < intervals.size(); i++) {
            int[] interval = intervals.get(i);

            if (interval[0] <= lastInterval[1]) {
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            } else {
                lastInterval = new int[] { interval[0], interval[1] };
                results.add(lastInterval);
            }
        }

        return results;
    }
}
