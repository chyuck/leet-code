package solutions;

import java.util.ArrayList;
import java.util.List;

import structures.TreeNode;

/**
 * Solution for https://leetcode.com/problems/binary-tree-paths/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList<>();

        if (root == null) {
            return results;
        }

        String path = Integer.toString(root.val);

        dfs(path, root, results);

        return results;
    }

    private static void dfs(String path, TreeNode node, List<String> results) {
        if (node.left == null && node.right == null) {
            results.add(path);
            return;
        }

        dfsForChild(path, node.left, results);
        dfsForChild(path, node.right, results);
    }

    private static void dfsForChild(String path, TreeNode node, List<String> results) {
        if (node != null) {
            dfs(path + "->" + node.val, node, results);
        }
    }
}
