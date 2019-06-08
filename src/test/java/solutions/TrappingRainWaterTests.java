package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class TrappingRainWaterTests {

    @Test public void testExampleForSolution1() {
        // arrange
        final var solution = new TrappingRainWater();

        // act
        final var result = solution.trap(new int[] { 0,1,0,2,1,0,1,3,2,1,2,1 });

        // assert
        assertEquals(6, result);
    }

    @Test public void testExampleForSolution2() {
        // arrange
        final var solution = new TrappingRainWater();

        // act
        final var result = solution.trap2(new int[] { 0,1,0,2,1,0,1,3,2,1,2,1 });

        // assert
        assertEquals(6, result);
    }
}
