package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class MinCostClimbingStairsTests {

    @Test public void testExample1() {
        // arrange
        var solution = new MinCostClimbingStairs();

        // act
        var result = solution.minCostClimbingStairs(new int[] { 10, 15, 20 });

        // assert
        assertEquals(15, result);
    }

    @Test public void testExample2() {
        // arrange
        var solution = new MinCostClimbingStairs();

        // act
        var result = solution.minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 });

        // assert
        assertEquals(6, result);
    }
}
