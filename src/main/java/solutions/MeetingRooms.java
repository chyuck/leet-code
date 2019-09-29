package solutions;

import java.util.Arrays;

public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return true;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int lastEndTime = 0;

        for (int[] interval : intervals) {
            if (interval[0] < lastEndTime)
                return false;

            lastEndTime = interval[1];
        }

        return true;
    }
}
