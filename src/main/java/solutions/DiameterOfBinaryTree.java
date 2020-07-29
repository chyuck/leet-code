package solutions;

import structures.TreeNode;

/**
 * Solution for https://leetcode.com/problems/diameter-of-binary-tree/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] result = new int[] { 0 };

        maxDepth(root, result);

        return result[0];
    }

    private static int maxDepth(TreeNode node, int[] result) {
        int left = node.left == null ? 0 : maxDepth(node.left, result) + 1;
        int right = node.right == null ? 0 : maxDepth(node.right, result) + 1;

        result[0] = Math.max(result[0], left + right);

        return Math.max(left, right);
    }
}
