package solutions;

import structures.TreeNode;

/**
 * Solution for https://leetcode.com/problems/closest-binary-search-tree-value/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        int result = root.val;
        TreeNode node = root;

        while (node != null) {
            int value = node.val;

            result = Math.abs(target - value) < Math.abs(target - result) ? value : result;

            node = target < value ? node.left : node.right;
        }

        return result;
    }
}
