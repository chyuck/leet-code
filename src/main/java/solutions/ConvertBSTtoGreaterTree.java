package solutions;

import structures.TreeNode;

/**
 * Solution for https://leetcode.com/problems/convert-bst-to-greater-tree problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 * where n - number of nodes in tree
 */
public class ConvertBSTtoGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        convert(root, 0);

        return root;
    }

    private int convert(TreeNode node, int sum) {
        // for last node, just return current sum
        if (node == null) return sum;

        // convert right subtree using current sum and return total subtree sum + current sum
        int right = convert(node.right, sum);

        // calculate new sum by summing up current node value, total subtree sum and current sum
        int newSum = node.val + right;

        // set new sum to current node
        node.val = newSum;

        // convert left sub tree using new sum and return new sum
        // left subtree results are ignored by parents but are used by grand parents
        return convert(node.left, newSum);
    }
}
