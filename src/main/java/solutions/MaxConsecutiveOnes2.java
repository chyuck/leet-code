package solutions;

/**
 * Solution for https://leetcode.com/problems/max-consecutive-ones-ii/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MaxConsecutiveOnes2 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;
        int countSinceFlipped = 0;
        boolean flipped = false;

        for (int num : nums) {
            if (num == 1) {
                count++;
                if (flipped) {
                    countSinceFlipped++;
                }
            } else {
                if (!flipped) {
                    count++;
                    countSinceFlipped = 1;
                    flipped = true;
                } else {
                    result = Math.max(result, count);
                    count = countSinceFlipped;
                    countSinceFlipped = 1;
                }
            }
        }

        return Math.max(result, count);
    }
}
