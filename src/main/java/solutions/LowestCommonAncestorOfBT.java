package solutions;

import structures.TreeNode;

/**
 * Solution for https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class LowestCommonAncestorOfBT {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
