package solutions;

/**
 * Solution for https://leetcode.com/problems/two-sum-ii-input-array-is-sorted problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class TwoSum2InputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        // create two pointers from beginning and end of array
        // that will be pointers two first and second numbers
        // and move them towards each other
        int index1 = 0;
        int index2 = numbers.length - 1;

        // do until two pointer met
        while (index2 > index1) {
            // get left and right numbers
            int number1 = numbers[index1];
            int number2 = numbers[index2];
            // calculate sum of left and right numbers
            int sum = number1 + number2;

            // if sum is equal to target, then solution is found
            if (sum == target)
                return new int[] { index1 + 1, index2 + 1 };

            // if sum is greater than target then decrease sum by moving right cursor to left
            if (sum > target) {
                index2--;
                continue;
            }

            // if sum is less than target then increase sum by moving left cursor to right
            index1++;
        }

        // no solution
        throw new IllegalStateException("No solution");
    }
}
