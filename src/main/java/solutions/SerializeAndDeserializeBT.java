package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution for https://leetcode.com/problems/serialize-and-deserialize-binary-tree/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 * where n - number of tree nodes
 */
public class SerializeAndDeserializeBT {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // return empty string for empty tree
        if (root == null) return "";

        // create string builder to accumulate serialization result
        final StringBuilder builder = new StringBuilder();
        // add root element
        builder.append(root.val);

        // create queue to traverse nodes level by level from top to bottom
        final Queue<TreeNode> queue = new LinkedList<>();
        // add left and right nodes
        queue.add(root.left);
        queue.add(root.right);

        // iterate through queue
        while (!queue.isEmpty()) {
            // remove node from queue
            final TreeNode node = queue.poll();

            // for null element, add "null"
            if (node == null) {
                builder.append(",null");
                continue;
            }

            // for not null, append node value
            builder.append(",");
            builder.append(node.val);

            // push to queue left and right nodes
            queue.add(node.left);
            queue.add(node.right);
        }

        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // return null for empty string
        if (data == null || data.length() == 0) return null;

        // Split data by comma to get all values
        final String[] values = data.split(",");

        // create root node
        final TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        // create queue to build nodes level by level from top to bottom
        final Queue<TreeNode> queue = new LinkedList<>();
        // add first node to queue
        queue.add(root);

        // index in values array
        int index = 0;
        // pull from queue until it is empty
        while (!queue.isEmpty()) {
            // pull parent node from queue
            final TreeNode parent = queue.poll();

            // left child node
            index++;
            if (!values[index].equals("null")) {
                final TreeNode node = new TreeNode(Integer.parseInt(values[index]));
                parent.left = node;
                queue.add(node);
            }

            // right child node
            index++;
            if (!values[index].equals("null")) {
                final TreeNode node = new TreeNode(Integer.parseInt(values[index]));
                parent.right = node;
                queue.add(node);
            }
        }

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
