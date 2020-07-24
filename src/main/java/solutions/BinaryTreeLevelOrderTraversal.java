package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import structures.TreeNode;

/**
 * Solution for https://leetcode.com/problems/binary-tree-level-order-traversal/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> results = new ArrayList<>();

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        while (!bfs.isEmpty()) {
            int levelSize = bfs.size();

            List<Integer> result = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = bfs.remove();

                if (node.left != null) {
                    bfs.add(node.left);
                }

                if (node.right != null) {
                    bfs.add(node.right);
                }

                result.add(node.val);
            }

            results.add(result);
        }

        return results;
    }
}
