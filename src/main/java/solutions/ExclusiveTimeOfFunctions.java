package solutions;

import java.util.List;
import java.util.Stack;

/**
 * Solution for https://leetcode.com/problems/exclusive-time-of-functions/ problem with
 * Time complexity: O(L)
 * Space complexity: O(L)
 * L - number of logs
 */
public class ExclusiveTimeOfFunctions {

    private static class Log {
        final int id;
        final boolean start;
        final int timestamp;

        private Log(String log) {
            String[] parts = log.split(":");

            this.id = Integer.parseInt(parts[0]);
            this.start = parts[1].equals("start");
            this.timestamp = Integer.parseInt(parts[2]);
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] results = new int[n];

        Stack<Integer> functionIds = new Stack<>();

        Log firstLog = new Log(logs.get(0));
        functionIds.push(firstLog.id);

        int time = firstLog.timestamp;

        for (int i = 1; i < logs.size(); i++) {
            Log log = new Log(logs.get(i));

            int timeDiff = log.timestamp - time;
            if (timeDiff > 0) {
                time += timeDiff;
                results[functionIds.peek()] += timeDiff;
            }

            if (log.start) {
                functionIds.push(log.id);
            } else {
                results[functionIds.peek()]++;
                time++;
                functionIds.pop();
            }
        }

        return results;
    }
}
