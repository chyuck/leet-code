package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumProductSubarrayTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new MaximumProductSubarray();

        // act
        var result = solution.maxProduct(new int[] {2,3,-2,4});

        // assert
        assertEquals(6, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new MaximumProductSubarray();

        // act
        var result = solution.maxProduct(new int[] {-2,0,-1});

        // assert
        assertEquals(0, result);
    }

    @Test
    public void testCase() {
        // arrange
        var solution = new MaximumProductSubarray();

        // act
        var result = solution.maxProduct(new int[] {-2,3,-4});

        // assert
        assertEquals(24, result);
    }
}
