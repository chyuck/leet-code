package solutions;

import structures.TreeNode;

/**
 * Solution for https://leetcode.com/problems/maximum-depth-of-binary-tree/ problem with
 * Time complexity: O(n)
 * Space complexity: O(log(n))
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return getMaxDepth(root, 0);
    }

    private int getMaxDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        return Math.max(getMaxDepth(node.left, depth + 1), getMaxDepth(node.right, depth + 1));
    }
}
