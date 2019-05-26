package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class TwoSumTests {
    @Test public void testExample() {
        // arrange
        var solution = new TwoSumSolution();

        // act
        var result = solution.twoSum(new int[] { 2, 7, 11, 15 }, 9);

        // assert
        assertArrayEquals(new int[] { 0, 1 }, result);
    }
}
