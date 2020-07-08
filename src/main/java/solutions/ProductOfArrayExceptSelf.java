package solutions;

/**
 * Solution for https://leetcode.com/problems/product-of-array-except-self problem with
 * Time complexity: O(n)
 * Space complexity: O(n), where n space is used for result array
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int[] results = createLeftProducts(nums);

        int rightProduct = 1;
        for (int i = length - 1; i >= 0; i--) {
            results[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return results;
    }

    private static int[] createLeftProducts(int[] nums) {
        int length = nums.length;

        int[] results = new int[length];
        results[0] = 1;

        for (int i = 1; i < length; i++) {
            results[i] = results[i - 1] * nums[i - 1];
        }

        return results;
    }
}