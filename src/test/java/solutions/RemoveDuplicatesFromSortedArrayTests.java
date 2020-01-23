package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicatesFromSortedArrayTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new RemoveDuplicatesFromSortedArray();

        int[] nums = new int[] {1,1,2};

        // act
        var result = solution.removeDuplicates(nums);

        // assert
        assertEquals(2, result);
        assertEquals(1, nums[0]);
        assertEquals(2, nums[1]);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new RemoveDuplicatesFromSortedArray();

        int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};

        // act
        var result = solution.removeDuplicates(nums);

        // assert
        assertEquals(5, result);
        assertEquals(0, nums[0]);
        assertEquals(1, nums[1]);
        assertEquals(2, nums[2]);
        assertEquals(3, nums[3]);
        assertEquals(4, nums[4]);
    }
}
