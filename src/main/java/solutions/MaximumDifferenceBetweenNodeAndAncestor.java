package solutions;

import structures.TreeNode;

/**
 * Solution for https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class MaximumDifferenceBetweenNodeAndAncestor {

    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiff(root, root.val, root.val);
    }

    private static int maxAncestorDiff(TreeNode node, int min, int max) {
        if (node == null) {
            return Math.abs(min - max);
        }

        int currentMin = Math.min(min, node.val);
        int currentMax = Math.max(max, node.val);

        int leftResult = maxAncestorDiff(node.left, currentMin, currentMax);
        int rightResult = maxAncestorDiff(node.right, currentMin, currentMax);

        return Math.max(leftResult, rightResult);
    }
}
