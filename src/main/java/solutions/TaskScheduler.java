package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/task-scheduler/ problem with
 * Time complexity: O(T)
 * Space complexity: O(1)
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }

        List<Integer> taskCounts = getTaskCounts(tasks);

        int maxTaskCount = getMaxTaskCount(taskCounts);
        int tasksWithMaxCount = getTasksWithMaxCount(taskCounts, maxTaskCount);

        return Math.max(tasks.length, (maxTaskCount - 1) * (n + 1) + tasksWithMaxCount);
    }

    private static List<Integer> getTaskCounts(char[] tasks) {
        Map<Character, Integer> results = new HashMap<>();

        for (char task : tasks) {
            Integer count = results.getOrDefault(task, 0);
            results.put(task, count + 1);
        }

        return new ArrayList<>(results.values());
    }

    private static int getMaxTaskCount(List<Integer> taskCounts) {
        int result = 0;

        for (Integer count : taskCounts) {
            result = Math.max(result, count);
        }

        return result;
    }

    private static int getTasksWithMaxCount(List<Integer> taskCounts, int maxTaskCount) {
        int result = 0;

        for (Integer count : taskCounts) {
            if (count == maxTaskCount) {
                result++;
            }
        }

        return result;
    }
}
