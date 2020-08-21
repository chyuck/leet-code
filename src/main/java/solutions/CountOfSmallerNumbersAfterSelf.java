package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Solution for https://leetcode.com/problems/count-of-smaller-numbers-after-self/ problem with
 * Time complexity: O(n * log(n))
 * Space complexity: O(n)
 */
public class CountOfSmallerNumbersAfterSelf {

    private static class Item {
        final int num;
        final int index;

        private Item(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }

        if (nums.length == 1) {
            return Arrays.asList(0);
        }

        Item[] items = createItems(nums);

        int[] counts = new int[nums.length];

        mergeSort(items, 0, nums.length - 1, counts);

        return convertToResult(counts);
    }

    private static Item[] createItems(int[] nums) {
        Item[] results = new Item[nums.length];

        for (int i = 0; i < nums.length; i++) {
            results[i] = new Item(nums[i], i);
        }

        return results;
    }

    private static void mergeSort(Item[] items, int lo, int hi, int[] counts) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;

        mergeSort(items, lo, mid, counts);
        mergeSort(items, mid + 1, hi, counts);

        merge(items, lo, mid, hi, counts);
    }

    private static void merge(Item[] items, int lo, int mid, int hi, int[] counts) {
        Item[] sorted = new Item[hi - lo + 1];
        int index = 0;

        int smallerNumberCounter = 0;

        int p1 = lo, p2 = mid + 1;

        while (p1 <= mid && p2 <= hi) {
            if (items[p2].num < items[p1].num) {
                smallerNumberCounter++;

                sorted[index++] = items[p2++];
            } else {
                counts[items[p1].index] += smallerNumberCounter;

                sorted[index++] = items[p1++];
            }
        }

        while (p1 <= mid) {
            counts[items[p1].index] += smallerNumberCounter;

            sorted[index++] = items[p1++];
        }

        while (p2 <= hi) {
            sorted[index++] = items[p2++];
        }

        for (int i = 0; i < sorted.length; i++) {
            items[lo + i] = sorted[i];
        }
    }

    private static List<Integer> convertToResult(int[] counts) {
        List<Integer> results = new ArrayList<>(counts.length);

        for (int count : counts) {
            results.add(count);
        }

        return results;
    }
}
