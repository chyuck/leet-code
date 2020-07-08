package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import structures.TreeNode;

/**
 * Solution for https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/ problem with
 * Time complexity: O(n * log(n))
 * Space complexity: O(n)
 */
public class VerticalOrderTraversalOfABinaryTree {

    private static class Node {
        final int y;
        final int x;
        final int val;

        private Node(int y, int x, int val) {
            this.y = y;
            this.x = x;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Set<Node> treeSet = createTreeSet(root);

        return convertTreeSetToResult(treeSet);
    }

    private static Set<Node> createTreeSet(TreeNode root) {
        Set<Node> results = new TreeSet<>((a, b) -> {
            if (a.y != b.y) {
                return a.y - b.y;
            }

            if (a.x != b.x) {
                return b.x - a.x;
            }

            return a.val - b.val;
        });

        dfs(root, 0, 0, results);

        return results;
    }

    private static void dfs(TreeNode node, int y, int x, Set<Node> results) {
        if (node == null) {
            return;
        }

        results.add(new Node(x, y, node.val));

        dfs(node.left, y - 1, x - 1, results);
        dfs(node.right, y - 1, x + 1, results);
    }

    private List<List<Integer>> convertTreeSetToResult(Set<Node> treeSet) {
        List<List<Integer>> results = new ArrayList<>();

        Integer lastY = null;

        List<Integer> currentResult = null;

        for (Node node : treeSet) {
            if (!Objects.equals(node.y, lastY)) {
                currentResult = new ArrayList<>();
                results.add(currentResult);

                lastY = node.y;
            }

            currentResult.add(node.val);
        }

        return results;
    }
}
