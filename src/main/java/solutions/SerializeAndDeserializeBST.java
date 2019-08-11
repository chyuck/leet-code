package solutions;

/**
 * Solution for https://leetcode.com/problems/serialize-and-deserialize-bst problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 * where n - number of tree nodes
 */
public class SerializeAndDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return null;

        StringBuilder builder = new StringBuilder();

        serialize(root, builder);

        // remove last comma
        builder.deleteCharAt(builder.length() - 1);

        return builder.toString();
    }

    private void serialize(TreeNode root, StringBuilder builder) {
        if (root == null) return;

        // first add value
        builder.append(root.val);
        builder.append(",");

        // then left and right subtrees
        serialize(root.left, builder);
        serialize(root.right, builder);
    }

    // index for decoding
    private int index;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;

        // parse values separated by comma
        String[] strings = data.split(",");

        // convert strings to integers
        int[] values = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            values[i] = Integer.parseInt(strings[i]);
        }

        // set index to start
        index = 0;

        // because we always start from left subtree and then right subtree, we care only about max value
        // start from integer max
        return deserialize(values, Integer.MAX_VALUE);
    }

    private TreeNode deserialize(int[] values, int max) {
        // end of values in input
        if (index >= values.length)
            return null;

        int value = values[index];

        // skip if value is greater than max
        if (value > max)
            return null;

        // create node and increment index
        TreeNode node = new TreeNode(value);
        index++;

        // max value is current node value, because all children must be less than current node
        node.left = deserialize(values, node.val);
        // max value is current max, because all children must be greater than current node, but less than parent max
        node.right = deserialize(values, max);

        return node;
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
