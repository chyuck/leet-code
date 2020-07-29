package solutions;

import structures.Stack;
import structures.TreeNode;

/**
 * Solution for https://leetcode.com/problems/binary-search-tree-iterator/ problem with
 * Time complexity: O(1) average
 * Space complexity: O(h)
 * where h - height of tree
 */
public class BinarySearchTreeIterator {

    private final Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        processLeftSubTree(root);
    }

    private void processLeftSubTree(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();

        processLeftSubTree(node.right);

        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
