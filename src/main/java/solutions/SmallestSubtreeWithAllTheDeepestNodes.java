package solutions;

import java.util.HashMap;
import java.util.Map;

import structures.TreeNode;

/**
 * Solution for https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class SmallestSubtreeWithAllTheDeepestNodes {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<TreeNode, Integer> depths = createDepthMap(root);

        Integer maxDepth = findMaxDepth(depths.values());

        return getSubtreeWithAllDeepest(root, depths, maxDepth);
    }

    private static Map<TreeNode, Integer> createDepthMap(TreeNode root) {
        Map<TreeNode, Integer> results = new HashMap<>();

        dfs(root, 0, results);

        return results;
    }

    private static void dfs(TreeNode node, Integer depth, Map<TreeNode, Integer> results) {
        if (node == null) {
            return;
        }

        results.put(node, depth);

        dfs(node.left, depth + 1, results);
        dfs(node.right, depth + 1, results);
    }

    private static Integer findMaxDepth(Iterable<Integer> values) {
        Integer result = -1;

        for (Integer value : values) {
            result = Math.max(result, value);
        }

        return result;
    }

    private static TreeNode getSubtreeWithAllDeepest(TreeNode node, Map<TreeNode, Integer> depths, Integer maxDepth) {
        if (node == null) {
            return null;
        }

        Integer depth = depths.get(node);
        if (depth == maxDepth) {
            return node;
        }

        TreeNode left = getSubtreeWithAllDeepest(node.left, depths, maxDepth);
        TreeNode right = getSubtreeWithAllDeepest(node.right, depths, maxDepth);

        if (left != null && right != null) {
            return node;
        }

        if (left != null) {
            return left;
        }

        if (right != null) {
            return right;
        }

        return null;
    }
}
