package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import structures.TreeNode;

/**
 * Solution for https://leetcode.com/problems/binary-tree-vertical-order-traversal/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class BinaryTreeVerticalOrderTraversal {

    private static class Item {
        private final TreeNode treeNode;
        private final int col;

        private Item(TreeNode treeNode, int col) {
            this.treeNode = treeNode;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Map<Integer, List<Integer>> columns = new HashMap<>();
        int minColumn = 0, maxColumn = 0;

        Queue<Item> bfs = new LinkedList<>();
        bfs.add(new Item(root, 0));

        while (!bfs.isEmpty()) {
            Item item = bfs.remove();

            if (!columns.containsKey(item.col)) {
                columns.put(item.col, new ArrayList<>());

                minColumn = Math.min(minColumn, item.col);
                maxColumn = Math.max(maxColumn, item.col);
            }

            columns.get(item.col).add(item.treeNode.val);

            if (item.treeNode.left != null) {
                bfs.add(new Item(item.treeNode.left, item.col - 1));
            }
            if (item.treeNode.right != null) {
                bfs.add(new Item(item.treeNode.right, item.col + 1));
            }
        }

        List<List<Integer>> results = new ArrayList<>();

        for (int i = minColumn; i <= maxColumn; i++) {
            List<Integer> column = columns.get(i);
            results.add(column);
        }

        return results;
    }
}
