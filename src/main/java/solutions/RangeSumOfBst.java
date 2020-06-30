package solutions;

import java.util.Stack;

import structures.TreeNode;

/**
 * Solution for https://leetcode.com/problems/range-sum-of-bst/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class RangeSumOfBst {

    public int rangeSumBST(TreeNode root, int L, int R) {
        return dfs(root, L, R);
    }

    private int dfs(TreeNode node, int L, int R) {
        if (node == null) {
            return 0;
        }

        int sum = 0;

        if (L <= node.val && node.val <= R) {
            sum += node.val;
        }

        if (node.val > L) {
            sum += dfs(node.left, L, R);
        }

        if (node.val < R) {
            sum += dfs(node.right, L, R);
        }

        return sum;
    }

    public int rangeSumBST2(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        int sum = 0;

        while (!stack.empty()) {
            TreeNode node = stack.pop();

            if (L <= node.val && node.val <= R) {
                sum += node.val;
            }

            if (node.val > L && node.left != null) {
                stack.push(node.left);
            }

            if (node.val < R && node.right != null) {
                stack.push(node.right);
            }
        }

        return sum;
    }
}
