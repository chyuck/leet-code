package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length <= 1) return true;
        if (numCourses == 0) return true;

        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            Set<Integer> children = graph.get(prerequisite[0]);
            if (children == null) children = new HashSet<>();
            children.add(prerequisite[1]);
            graph.put(prerequisite[0], children);
        }

        HashSet<Integer> visited = new HashSet<>();

        for (Integer i=0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) return false;
        }

        return true;
    }

    private boolean dfs(HashMap<Integer, Set<Integer>> graph, HashSet<Integer> visited, Integer num) {
        if (visited.contains(num))
            return false;

        visited.add(num);

        Set<Integer> children = graph.get(num);
        if (children != null) {
            for (Integer child : children) {
                if (!dfs(graph, visited, child)) return false;
            }
        }

        visited.remove(num);

        return true;
    }
}
