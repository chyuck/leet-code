package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubarraySumEqualsKTests {

    @Test
    public void testExample() {
        // arrange
        var solution = new SubarraySumEqualsK();

        // act
        var result = solution.subarraySum(new int[] { 1,1,1 }, 2);

        // assert
        assertEquals(result, 2);
    }
}
