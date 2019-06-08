package solutions;

/**
 * Solution for https://leetcode.com/problems/trapping-rain-water problem with
 * Time complexity: O(n)
 */
public class TrappingRainWater {

    /**
     * Space complexity: O(1)
     */
    public int trap(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        // read another solution first, to understand current solution better

        int result = 0;
        int leftMax = 0, rightMax = 0;
        int leftIndex = 0, rightIndex = heights.length - 1;

        // iterate until pointers meet
        while (leftIndex < rightIndex) {

            // left elevation is less than right elevation, move left pointer
            // in this case we know that on the right we have higher bar and water trap depends on left side
            if (heights[leftIndex] < heights[rightIndex]) {
                // left elevation is less than max left elevation, add to result
                if (heights[leftIndex] < leftMax)
                    result += leftMax - heights[leftIndex];

                // update left max elevation
                leftMax = Math.max(leftMax, heights[leftIndex]);
                // move pointer
                leftIndex++;

                continue;
            }

            // left elevation is greater than of e1ual to right elevation, move right pointer
            // in this case we know that on the left we have higher bar and water trap depends on right side

            // right elevation is less than max right elevation, add to result
            if (heights[rightIndex] < rightMax)
                result += rightMax - heights[rightIndex];

            // update right max elevation
            rightMax = Math.max(rightMax, heights[rightIndex]);
            // move pointer
            rightIndex--;
        }

        return result;
    }

    /**
     * Space complexity: O(n)
     */
    public int trap2(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        // calculate left max elevations for each index, based on previous left max index
        final int[] leftMax = new int[heights.length];
        leftMax[0] = heights[0];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }

        // calculate right max elevations for each index, based on previous right max index
        final int[] rightMax = new int[heights.length];
        rightMax[heights.length - 1] = heights[heights.length - 1];
        for (int i = heights.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }

        int result = 0;

        // accumulate water traps for each index based on left and right maxes
        for (int i = 0; i < heights.length; i++) {
            result += Math.min(leftMax[i], rightMax[i]) - heights[i];
        }

        return result;
    }
}