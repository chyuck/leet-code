package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class TwoSum2InputArrayIsSortedTests {

    @Test public void testExample() {
        // arrange
        var solution = new TwoSum2InputArrayIsSorted();

        // act
        var result = solution.twoSum(new int[] { 2,7,11,15 }, 9);

        // assert
        assertArrayEquals(new int[] { 1,2 }, result);
    }
}
