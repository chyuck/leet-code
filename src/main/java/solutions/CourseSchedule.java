package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solution for https://leetcode.com/problems/course-schedule/ problem with
 * Time complexity: O(C + P)
 * Space complexity: O(C + P)
 * where C - number of courses, P - number of prerequisites
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = buildGraph(prerequisites);

        return topologicalTraversal(numCourses, graph);
    }

    private Map<Integer, Set<Integer>> buildGraph(int[][] prerequisites) {
        Map<Integer, Set<Integer>> results = new HashMap<>();

        for (int[] edge : prerequisites) {
            int course1 = edge[0];
            int course2 = edge[1];

            Set<Integer> existingResult = results.get(course1);
            Set<Integer> result = existingResult != null ? existingResult : new HashSet<>();

            result.add(course2);

            results.put(course1, result);
        }

        return results;
    }

    class InvalidOrderException extends RuntimeException {}

    enum VisitStatus { VISITING, VISITED }

    private boolean topologicalTraversal(int numCourses, Map<Integer, Set<Integer>> graph) {
        Map<Integer, VisitStatus> visited = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            try {
                dfs(i, graph, visited);
            } catch (InvalidOrderException e) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int course, Map<Integer, Set<Integer>> graph, Map<Integer, VisitStatus> visited) {
        VisitStatus status = visited.get(course);
        if (status == null) {
            visited.put(course, VisitStatus.VISITING);
        } else if (status == VisitStatus.VISITED) {
            return;
        } else {
            throw new InvalidOrderException();
        }

        Set<Integer> children = graph.get(course);
        if (children != null) {
            for (Integer child : children) {
                dfs(child, graph, visited);
            }
        }

        visited.put(course, VisitStatus.VISITED);
    }
}
