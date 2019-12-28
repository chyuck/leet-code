package solutions;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortedArrayTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new MergeSortedArray();

        var nums1 = new int[] { 1,2,3,0,0,0 };
        var nums2 = new int[] { 2,5,6 };

        // act
        solution.merge(nums1, 3, nums2, 3);

        // assert
        assertArrayEquals(new int[] { 1,2,2,3,5,6 }, nums1);
    }
}
