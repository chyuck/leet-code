package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Solution for https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class LowestCommonAncestorOfBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // end of tree
        if (root == null)
            return null;

        // when current node is p or q then current node is candidate for lowest common ancestor
        // "p and q are different and both values will exist in the binary tree."
        // if p is current node and q is one of descendants that means current node is lowest common ancestor
        // if p is current node and q is NOT one of descendants that means another ancestor of current node is lowest common ancestor
        if (p == root || q == root)
            return root;

        final TreeNode left = lowestCommonAncestor(root.left, p, q);
        final TreeNode right = lowestCommonAncestor(root.right, p, q);

        // if both left and right descendants contains p and q, the current node is lowest common ancestor
        // "All of the nodes' values will be unique"
        if (left != null && right != null)
            return root;

        // if only left descendants contains p or q then left node is candidate for lowest common ancestor
        if (left != null)
            return left;

        // if only right descendants contains p or q then right node is candidate for lowest common ancestor
        if (right != null)
            return right;

        // descendants do not contain p or q
        return null;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // if p or q are root then root is the only common ancestor
        if (p == root || q == root)
            return root;

        // nodes to parent nodes mapping
        final HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        // add root node
        parents.put(root, null);

        // stack for depth first traverse
        final Stack<TreeNode> stack = new Stack<>();
        // add root node
        stack.push(root);

        // iterate until we found paths for both p and q
        while (!parents.containsKey(p) || !parents.containsKey(q)) {
            // get top node from stack
            final TreeNode node = stack.pop();

            // process right sub node
            if (node.right != null) {
                parents.put(node.right, node);
                stack.push(node.right);
            }

            // process left sub node
            if (node.left != null) {
                parents.put(node.left, node);
                stack.push(node.left);
            }
        }

        // copy and store path for p
        final HashSet<TreeNode> path = new HashSet<>();
        // traverse from p up to root
        while (p != null) {
            path.add(p);
            p = parents.get(p);
        }

        // traverse from q to first element in p path
        while (!path.contains(q)) {
            q = parents.get(q);
        }

        // return first common ancestor for p and q
        return q;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this(val);
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return Integer.toString(this.val);
        }
    }
}
