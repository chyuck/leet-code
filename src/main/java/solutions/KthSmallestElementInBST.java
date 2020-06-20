package solutions;

/**
 * Solution for https://leetcode.com/problems/kth-smallest-element-in-a-bst/ problem with
 * Time complexity: O(k)
 * Space complexity: O(k)
 */

public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {
        int[] vars = new int[2];

        inorder(root, k, vars);

        return vars[1];
    }

    private static void inorder(TreeNode node, int k, int[] vars) {
        if (node == null) {
            return;
        }

        if (vars[1] > 0) {
            return;
        }

        inorder(node.left, k, vars);

        if (++vars[0] == k) {
            vars[1] = node.val;
        }

        inorder(node.right, k, vars);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
