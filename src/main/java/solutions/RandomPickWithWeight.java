package solutions;

import java.util.Random;

/**
 * Solution for https://leetcode.com/problems/random-pick-with-weight/ problem
 */
public class RandomPickWithWeight {

    private final Random random = new Random();

    private final int[] ranges;

    /**
     * Time complexity: O(w)
     * Space complexity: O(w)
     */
    public RandomPickWithWeight(int[] w) {
        ranges = buildRanges(w);
    }

    private int[] buildRanges(int[] w) {
        int[] result = new int[w.length];
        result[0] = w[0];

        for (int i = 1; i < w.length; i++) {
            result[i] = result[i - 1] + w[i];
        }

        return result;
    }

    /**
     * Time complexity: O(log(w))
     * Space complexity: O(1)
     */
    public int pickIndex() {
        int maxRange = ranges[ranges.length - 1];

        int randomNumber = random.nextInt(maxRange) + 1;

        return findIndex(randomNumber);
    }

    private int findIndex(int randomNumber) {
        int left = 0;
        int right = ranges.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (ranges[mid] < randomNumber && randomNumber <= ranges[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
