package solutions;

import structures.TreeNode;

/**
 * Solution for https://leetcode.com/problems/symmetric-tree/ problem with
 * Time complexity: O(T1 + T2)
 * Space complexity: O(T1 + T2)
 * where T1, T2 - number of nodes in trees
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
