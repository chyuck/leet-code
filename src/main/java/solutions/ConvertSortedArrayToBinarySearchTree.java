package solutions;

/**
 * Solution for https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return createBST(nums, 0, nums.length - 1);
    }

    private TreeNode createBST(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }

        if (startIndex == endIndex) {
            return new TreeNode(nums[startIndex]);
        }

        int middleIndex = (startIndex + endIndex) / 2;

        TreeNode node = new TreeNode(nums[middleIndex]);
        node.left = createBST(nums, startIndex, middleIndex - 1);
        node.right = createBST(nums, middleIndex + 1, endIndex);

        return node;
    }

    public class TreeNode {
        final int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
