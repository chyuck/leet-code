package solutions;

import structures.TreeNode;

/**
 * Solution for https://leetcode.com/problems/binary-tree-maximum-path-sum/ problem with
 * Time complexity: O(n)
 * Space complexity: O(log(n))
 */
public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        int[] result = new int[] { Integer.MIN_VALUE };

        maxPathSum(root, result);

        return result[0];
    }

    private static int maxPathSum(TreeNode node, int[] result) {
        if (node == null) {
            return 0;
        }

        int maxLeftSum = maxPathSum(node.left, result);
        int maxRightSum = maxPathSum(node.right, result);

        int maxPathSum = max(node.val, node.val + maxLeftSum, node.val + maxRightSum);

        result[0] = max(result[0], maxPathSum, node.val + maxLeftSum + maxRightSum);

        return maxPathSum;
    }

    private static int max(int value1, int value2, int value3) {
        int maxFor1and2 = Math.max(value1, value2);

        return Math.max(maxFor1and2, value3);
    }
}
