package solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Solution for https://leetcode.com/problems/is-graph-bipartite/ problem with
 * Time complexity: O(N + E)
 * Space complexity: O(N)
 * where N - nodes, E - edges
 */
public class IsGraphBipartite {

    private enum Group { ONE, TWO }

    public boolean isBipartite(int[][] graph) {
        Map<Integer, Group> groups = new HashMap<>();
        Queue<Integer> bfs = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (groups.containsKey(i) || graph[i].length == 0) {
                continue;
            }

            groups.put(i, Group.ONE);
            bfs.add(i);

            while (!bfs.isEmpty()) {
                Integer node = bfs.remove();
                Group group = groups.get(node);
                Group nextGroup = group == Group.ONE ? Group.TWO : Group.ONE;

                int[] nextNodes = graph[node];
                for (int nextNode : nextNodes) {
                    Group nextNodeGroup = groups.get(nextNode);
                    if (nextNodeGroup != null) {
                        if (nextNodeGroup != nextGroup) {
                            return false;
                        }
                    } else {
                        groups.put(nextNode, nextGroup);
                        bfs.add(nextNode);
                    }
                }
            }
        }

        return true;
    }
}
