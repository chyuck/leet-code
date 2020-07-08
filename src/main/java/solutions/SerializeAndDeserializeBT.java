package solutions;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import structures.TreeNode;

/**
 * Solution for https://leetcode.com/problems/serialize-and-deserialize-binary-tree/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 * where n - number of tree nodes
 */
public class SerializeAndDeserializeBT {

    private static final String NULL_VALUE = "n";

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder results = new StringBuilder();
        results.append(root.val);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            serializeNode(node.left, queue, results);
            serializeNode(node.right, queue, results);
        }

        return results.toString();
    }

    private static void serializeNode(TreeNode node, Queue<TreeNode> queue, StringBuilder results) {
        if (node != null) {
            results.append(",").append(node.val);
            queue.add(node);
        } else {
            results.append(",").append(NULL_VALUE);
        }
    }

    public TreeNode deserialize(String data) {
        if (data == null || data == "") {
            return null;
        }

        String[] parts = data.split(",");

        int index = 0;

        TreeNode root = new TreeNode(Integer.parseInt(parts[index++]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            node.left = deserializeNode(parts[index++], queue);
            node.right = deserializeNode(parts[index++], queue);
        }

        return root;
    }

    private static TreeNode deserializeNode(String value, Queue<TreeNode> queue) {
        if (Objects.equals(value, NULL_VALUE)) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));
        queue.add(node);

        return node;
    }
}
