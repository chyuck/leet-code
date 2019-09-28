package solutions;

/**
 * Solution for https://leetcode.com/problems/container-with-most-water/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int leftHeight = height[left], rightHeight = height[right];

            int minHeight = Math.min(leftHeight, rightHeight);
            int distance = right - left;
            int water = minHeight * distance;

            maxWater = Math.max(maxWater, water);

            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
