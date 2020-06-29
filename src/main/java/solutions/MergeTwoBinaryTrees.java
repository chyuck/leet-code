package solutions;

import structures.TreeNode;

/**
 * Solution for https://leetcode.com/problems/merge-two-binary-trees/ problem with
 * Time complexity: O(T1 + T2)
 * Space complexity: O(T1 + T2)
 * where T1, T2 - number of nodes in trees
 */
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // if one of subtrees are null, return entire another subtree
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        // merge subtrees by summing up values and merging each subtree
        TreeNode result = new TreeNode(t1.val + t2.val);
        result.left = mergeTrees(t1.left, t2.left);
        result.right = mergeTrees(t1.right, t2.right);

        return result;
    }
}
