package solutions;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import structures.TreeNode;

/**
 * Solutions for https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class BinaryTreeZigzagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // create empty results
        final List<List<Integer>> results = new LinkedList<>();
        // if root is null then return empty results
        if (root == null)
            return results;

        // flag for current level direction
        boolean leftToRight = true;

        // stack with all nodes for current level
        Stack<TreeNode> stack = new Stack<>();
        // add first level to stack
        stack.add(root);

        // just keep iterating until we traverse all nodes level by level
        while (!stack.isEmpty()) {

            // list for accumulating level results
            final LinkedList<Integer> result = new LinkedList<>();
            // stack with all nodes for the next level
            final Stack<TreeNode> newStack = new Stack<>();

            // iterate through nodes on current level
            while (!stack.isEmpty()) {
                // take current level node
                final TreeNode node = stack.pop();
                // add to current level results
                result.add(node.val);

                // current level has left-to-right direction
                if (leftToRight) {
                    addToStackIfNotNull(newStack, node.left);
                    addToStackIfNotNull(newStack, node.right);
                } else {
                    addToStackIfNotNull(newStack, node.right);
                    addToStackIfNotNull(newStack, node.left);
                }
            }

            // if not the last level, add to results
            if (result.size() > 0)
                results.add(result);

            // change direction
            leftToRight = !leftToRight;
            // set next level stack as current level stack
            stack = newStack;
        }

        return results;
    }

    private static void addToStackIfNotNull(final Stack<TreeNode> stack, final TreeNode node) {
        if (node == null)
            return;
        stack.push(node);
    }
}
