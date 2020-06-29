package solutions;

import structures.TreeNode;

/**
 * Solution for https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class LowestCommonAncestorOfBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode pointer = root;

        while (pointer != null) {
            // if pointer is one of nodes, then pointer is LCA
            if (pointer.val == p.val || pointer.val == q.val)
                return pointer;

            // if nodes are in different subtrees, then pointer is LCA
            if ((pointer.val > p.val) == (pointer.val < q.val))
                return pointer;

            // nodes at the same subtree, switch pointer to proper subtree
            pointer = pointer.val < p.val ? pointer.right : pointer.left;
        }

        throw new IllegalStateException("No solution");
    }
}
