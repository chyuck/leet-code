package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solution for https://leetcode.com/problems/time-needed-to-inform-all-employees/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class TimeNeededToInformAllEmployees {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> subordinates = graph.computeIfAbsent(manager[i], m -> new HashSet<>());
            subordinates.add(i);
        }

        return maxInformTime(headID, graph, informTime);
    }

    private static int maxInformTime(int id, Map<Integer, Set<Integer>> graph, int[] informTime) {
        Set<Integer> subordinates = graph.get(id);
        if (subordinates == null) {
            return 0;
        }

        int result = 0;

        for (Integer subordinateId : subordinates) {
            int maxInformTime = maxInformTime(subordinateId, graph, informTime);
            result = Math.max(result, maxInformTime);
        }

        return result + informTime[id];
    }
}
