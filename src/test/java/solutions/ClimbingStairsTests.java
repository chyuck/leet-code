package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClimbingStairsTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new ClimbingStairs();

        // act
        var result = solution.climbStairs(2);

        // assert
        assertEquals(2, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new ClimbingStairs();

        // act
        var result = solution.climbStairs(3);

        // assert
        assertEquals(3, result);
    }
}
