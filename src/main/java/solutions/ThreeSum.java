package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution for https://leetcode.com/problems/3sum/ problem with
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 * where n - size of input array
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        // create results
        List<List<Integer>> results = new ArrayList<>();

        // if input is null, return empty results
        if (nums == null)
            return results;

        // save input array size
        int n = nums.length;

        // if input array has less than 3 numbers, return empty results
        if (n < 3)
            return results;

        // IDEA: Sort input numbers and have 3 pointers:
        // 1st loops from 0 number up to n-3
        // 2nd (left) loops from 1st + 1 up to 3rd (right)
        // 3rd (right) loops from n-1 down to 2nd (left)
        // if sum = 0, add to results and increment 2nd (left)
        // if sum > 0, decrement 3rd (right)
        // if sum < 0, increment 2nd (left)
        // skip repeated numbers, when moving any pointers

        // sort input array
        Arrays.sort(nums);

        // initialize 1st pointer
        int first = 0;

        // loop 1st pointer from 0 number up to n-3
        while (first < n - 2) {
            // save first number
            int firstNum = nums[first];

            // initialize 2nd (left) and 3rd (right) pointers
            int second = first + 1, third = n - 1;

            // loop 2nd (left) pointer from 1st + 1 up to 3rd (right)
            // loop 3rd (right) pointer from n-1 down to 2nd (left)
            while (second < third) {
                // save second and third numbers
                int secondNum = nums[second], thirdNum = nums[third];
                // calculate sum
                int sum = firstNum + secondNum + thirdNum;

                // if sum is greater than 0, decrement 3rd (right) pointer
                // skip repeated numbers
                if (sum > 0) {
                    while (second < third && nums[third] == thirdNum) {
                        third--;
                    }

                    continue;
                }

                // if sum is 0, result found
                // add to results
                // increment 2nd (left) pointer
                // skip repeated numbers
                if (sum == 0) {
                    List<Integer> result = new ArrayList<>();
                    result.add(firstNum);
                    result.add(secondNum);
                    result.add(thirdNum);

                    results.add(result);
                }

                // if sum is less than 0, increment 2nd (left) pointer
                // skip repeated numbers
                while (second < third && nums[second] == secondNum) {
                    second++;
                }
            }

            // when iterated 2nd and 3rd
            // increment 1st and continue
            // skip repeated numbers
            while (first < n && nums[first] == firstNum) {
                first++;
            }
        }

        return results;
    }
}
