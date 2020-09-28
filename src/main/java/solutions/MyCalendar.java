package solutions;

import java.util.Map;
import java.util.TreeMap;

/**
 * Solution for https://leetcode.com/problems/my-calendar-i/ problem with
 * Time complexity: O(log(n))
 * Space complexity: O(n)
 */
public class MyCalendar {

    private final TreeMap<Integer, Integer> schedule = new TreeMap<>();

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> prevEntry = schedule.lowerEntry(end);

        if (prevEntry != null && prevEntry.getValue() > start) {
            return false;
        }

        schedule.put(start, end);

        return true;
    }
}
