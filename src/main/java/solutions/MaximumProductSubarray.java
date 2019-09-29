package solutions;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int max = nums[0], min = nums[0], totalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int currentMax = max, currentMin = min;

            max = Math.max(Math.max(currentMax * num, currentMin * num), num);
            min = Math.min(Math.min(currentMax * num, currentMin * num), num);

            totalMax = Math.max(totalMax, max);
        }

        return totalMax;
    }
}
