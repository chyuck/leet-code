package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Solution for https://leetcode.com/problems/clone-graph/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> visited = new HashMap<>();
        visited.put(node, new Node(node.val));

        Queue<Node> bfs = new LinkedList<>();
        bfs.add(node);

        while (!bfs.isEmpty()) {
            Node current = bfs.remove();
            Node currentClone = visited.get(current);

            for (Node neighbor : current.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val));
                    bfs.add(neighbor);
                }

                Node neighborClone = visited.get(neighbor);

                currentClone.neighbors.add(neighborClone);
            }
        }

        return visited.get(node);
    }

    static class Node {
        public final int val;
        public final List<Node> neighbors;

        public Node() {
            this.val = 0;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }
}
