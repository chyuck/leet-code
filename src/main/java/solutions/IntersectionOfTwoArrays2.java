package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/intersection-of-two-arrays-ii/ problem with
 * Time complexity: O(A + B)
 * Space complexity: O(min(A,B))
 */
public class IntersectionOfTwoArrays2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return new int[0];
        }
        if (nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        if (nums1.length > nums2.length) {
            intersect(nums2, nums1);
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums1) {
            Integer count = counts.getOrDefault(num, 0);
            counts.put(num, count + 1);
        }

        List<Integer> results = new ArrayList<>();

        for (int num : nums2) {
            Integer count = counts.getOrDefault(num, 0);
            if (count > 0) {
                results.add(num);
                counts.put(num, count - 1);
            }
        }

        int[] array = new int[results.size()];
        int index = 0;
        for (Integer result : results) {
            array[index++] = result;
        }

        return array;
    }
}
