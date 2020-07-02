package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import structures.TreeNode;

/**
 * Solution for https://leetcode.com/problems/delete-nodes-and-return-forest/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class DeleteNodesAndReturnForest {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (to_delete == null || to_delete.length == 0) {
            return Collections.singletonList(root);
        }

        Set<Integer> deleteSet = toSet(to_delete);

        return deleteNodes(root, deleteSet);
    }

    private Set<Integer> toSet(int[] to_delete) {
        Set<Integer> results = new HashSet<>();

        for (int i : to_delete) {
            results.add(i);
        }

        return results;
    }

    private List<TreeNode> deleteNodes(TreeNode root, Set<Integer> deleteSet) {
        List<TreeNode> results = new ArrayList<>();

        if (!deleteSet.contains(root.val)) {
            results.add(root);
        }

        traverse(root, deleteSet, results);

        return results;
    }

    private TreeNode traverse(TreeNode node, Set<Integer> deleteSet, List<TreeNode> results) {
        if (node == null) {
            return null;
        }

        node.left = traverse(node.left, deleteSet, results);
        node.right = traverse(node.right, deleteSet, results);

        if (deleteSet.contains(node.val)) {
            if (node.left != null) {
                results.add(node.left);
            }

            if (node.right != null) {
                results.add(node.right);
            }

            return null;
        }

        return node;
    }
}
