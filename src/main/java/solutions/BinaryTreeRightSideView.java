package solutions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solutions for https://leetcode.com/problems/binary-tree-right-side-view problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        // create results
        List<Integer> results = new LinkedList<>();

        if (root == null) return results;

        // create BFS queue
        Queue<TreeNode> queue = new LinkedList<>();
        // add first level only node to queue
        queue.add(root);

        // traverse tree level by level
        while (!queue.isEmpty()) {
            // save level size
            int levelSize = queue.size();
            // iterate current level nodes from left to right
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.remove();

                // if last node in level, add to results
                if (i == levelSize - 1)
                    results.add(node.val);

                // add next level nodes to queue
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }

        return results;
    }

    public class TreeNode {
        final int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this(val);
            this.left = left;
            this.right = right;
        }
    }
}
