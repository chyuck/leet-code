package solutions;

/**
 * Solution for https://leetcode.com/problems/median-of-two-sorted-arrays/ problem with
 * Time complexity: O(log(min(n,m)))
 * Space complexity: O(1)
 * where n,m - lengths of input arrays
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;

        // take minimum size of two arrays, nums1 should be less or equal of nums2
        if (length1 > length2)
            return findMedianSortedArrays(nums2, nums1);

        // partition numbers in nums1 using binary search
        // based on partitioning of nums1, partition nums2, so 0 =< left partition - right partition <= 1
        // find partitioning when max(left partition) <= min(right partition)
        // if odd count of numbers, return max(left partition)
        // if even count of numbers, return (max(left partition) + min(right partition)) / 2

        // init and set low and high boundaries for partition position of nums1
        int low = 0, high = length1;

        // iterate until solution is found, solution always exists
        while (true) {
            // calculate partition position using binary search for nums1
            int partition1 = (low + high) / 2;
            // calculate partition position for nums2 based on partition position for nums1
            // use formula: partition1 + partition2 = (length1 + length2 + 1) / 2
            int partition2 = (length1 + length2 + 1) / 2 - partition1;

            // calculate max(left of partition1) and max(left of partition2)
            // if no numbers on the left, set -infinity, to ignore it on the next steps
            int maxLeft1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int maxLeft2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];

            // calculate min(right of partition1) and min(right of partition2)
            // if no numbers on the right, set +infinity, to ignore it on the next steps
            int minRight1 = partition1 == length1 ? Integer.MAX_VALUE : nums1[partition1];
            int minRight2 = partition2 == length2 ? Integer.MAX_VALUE : nums2[partition2];

            // calculate max(left) and min(right)
            int maxLeft = Math.max(maxLeft1, maxLeft2);
            int minRight = Math.min(minRight1, minRight2);

            // if current partitioning is correct, then solution is found, return result
            if (maxLeft <= minRight) {
                // if odd count of numbers, then return median as max(left)
                if ((length1 + length2) % 2 == 1) {
                    return maxLeft;
                }

                // if even count of numbers, then return median as (max(left) + min(right)) / 2
                return (maxLeft + minRight) / 2.0;
            }

            // let's find what side (left or right) we need to move partition1 position using binary search
            // note that always maxLeft1 <= minRight1, maxLeft2 <= minRight2
            // so there can be only two cases
            // 1. maxLeft1 > minRight2
            // 2. maxLeft2 > minRight1

            // if max(left of partition1) > min(right of partition2)
            // then we need to move partition1 position to the left, to decrease max(left of partition1)
            if (maxLeft1 > minRight2) {
                // lower bound stays the same, set upper bound to next position to the left after current position
                high = partition1 - 1;
                continue;
            }

            // if max(left of partition2) > min(right of partition1)
            // then we need to move partition1 position to the right, to increase min(right of partition1)

            // upper bound stays the same, set lower bound to next position to the right after current position
            low = partition1 + 1;
        }
    }
}
