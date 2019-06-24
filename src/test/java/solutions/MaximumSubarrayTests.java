package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class MaximumSubarrayTests {

    @Test public void testExample() {
        // arrange
        var solution = new MaximumSubarray();

        // act
        var result = solution.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});

        // assert
        assertEquals(6, result);
    }
}
