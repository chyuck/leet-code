package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Solution for https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class NumberOfConnectedComponentsInGraph {

    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = buildGraph(edges);

        return getNumberOfConnectedComponents(n, graph);
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> results = new HashMap<>();

        for (int[] edge : edges) {
            addGraphEdge(results, edge[0], edge[1]);
            addGraphEdge(results, edge[1], edge[0]);
        }

        return results;
    }

    private void addGraphEdge(Map<Integer, List<Integer>> graph, int a, int b) {
        List<Integer> existingValues = graph.get(a);
        List<Integer> values = existingValues != null ? existingValues : new ArrayList<>();

        values.add(b);
        graph.put(a, values);
    }

    private int getNumberOfConnectedComponents(int n, Map<Integer, List<Integer>> graph) {
        int result = 0;

        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i, graph, visited);
                result++;
            }

            if (visited.size() == n) {
                break;
            }
        }

        return result;
    }

    private void dfs(int i, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(i)) {
            return;
        }

        visited.add(i);

        List<Integer> values = graph.get(i);
        if (values == null) {
            return;
        }

        for (int value : values) {
            dfs(value, graph, visited);
        }
    }

}
