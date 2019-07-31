package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution for https://leetcode.com/problems/binary-tree-level-order-traversal/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 * where n - number of tree nodes
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // create list for results
        List<List<Integer>> results = new ArrayList<>();

        // return empty result if tree is empty
        if (root == null)
            return results;

        // create BFS queue to iterate tree level by level
        Queue<TreeNode> queue = new LinkedList<>();
        // add first level only node to queue
        queue.add(root);

        // loop until we traverse all tree nodes
        while (!queue.isEmpty()) {
            // save current level size
            int levelSize = queue.size();

            // create list for current level values
            List<Integer> result = new ArrayList<>(levelSize);

            // iterate only current level tree nodes
            for (int i = 0; i < levelSize; i++) {
                // remove node from queue
                TreeNode node = queue.remove();
                // add value to current level values
                result.add(node.val);

                // add left child node to next level, if it exists
                if (node.left != null)
                    queue.add(node.left);
                // add right child node to next level, if it exists
                if (node.right != null)
                    queue.add(node.right);
            }

            // add current level values to results
            results.add(result);
        }

        // return results
        return results;
    }

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this(val);
            this.left = left;
            this.right = right;
        }
    }
}
