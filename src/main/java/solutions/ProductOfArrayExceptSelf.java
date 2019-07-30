package solutions;

/**
 * Solution for https://leetcode.com/problems/product-of-array-except-self problem with
 * Time complexity: O(n)
 * Space complexity: O(n), where n space is used for result array
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        // create result array the same size as input array
        // and use it for storing right products for indexes
        int[] results = new int[nums.length];
        results[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            results[i] = results[i - 1] * nums[i - 1];
        }

        // convert input array for storing left products for indexes
        int prevNum = nums[nums.length - 1];
        nums[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            int product = nums[i + 1] * prevNum;
            prevNum = nums[i];
            nums[i] = product;
        }

        // set to the result array, product of left and right products for each index
        for (int i = 0; i < nums.length; i++) {
            results[i] *= nums[i];
        }

        // return result
        return results;
    }
}
