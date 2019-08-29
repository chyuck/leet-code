package solutions;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Solution for https://leetcode.com/problems/meeting-rooms-ii/ problem with
 * Time complexity: O(n * log(n))
 * Space complexity: O(n)
 */
public class MeetingRooms2 {

    public int minMeetingRooms(Interval[] intervals) {
        // if no intervals given, return 0 rooms needed
        if (intervals == null || intervals.length == 0)
            return 0;

        // sort interval by start time
        Arrays.sort(intervals, (a, b) -> a.start - b.start);

        // create min heap to keep all end times for rooms and to keep min available end time at top
        PriorityQueue<Integer> minEndTimeHeap = new PriorityQueue<>();
        // add first interval's end time
        minEndTimeHeap.add(intervals[0].end);

        // iterate through the rest of intervals
        for (int i = 1; i < intervals.length; i++) {
            // get interval at given index
            Interval interval = intervals[i];
            // get min available end time
            int minAvailableEndTime = minEndTimeHeap.peek();

            // if there is a room which can be reused for current interval
            if (minAvailableEndTime <= interval.start) {
                // to update availability of current room, replace min available end time with end time of current interval
                minEndTimeHeap.remove();
                minEndTimeHeap.add(interval.end);
                continue;
            }

            // if there is no room can be reused for current interval
            // add another room
            minEndTimeHeap.add(interval.end);
        }

        // return number of rooms
        return minEndTimeHeap.size();
    }

    public class Interval {
        final int start;
        final int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
      }
    }
}
