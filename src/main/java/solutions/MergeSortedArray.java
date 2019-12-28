package solutions;

/**
 * Solution for https://leetcode.com/problems/merge-sorted-array/ problem with
 * Time complexity: O(m + n)
 * Space complexity: O(1)
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int target = n + m - 1;
        int p1 = m - 1;
        int p2 = n - 1;

        while (p2 >= 0) {
            if (p1 < 0 || nums2[p2] >= nums1[p1]) {
                nums1[target--] = nums2[p2--];
            } else {
                nums1[target--] = nums1[p1--];
            }
        }
    }
}
