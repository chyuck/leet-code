package solutions;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MaximumNumberOfBalloonsTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new MaximumNumberOfBalloons();

        // act
        var result = solution.maxNumberOfBalloons("nlaebolko");

        // assert
        assertEquals(1, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new MaximumNumberOfBalloons();

        // act
        var result = solution.maxNumberOfBalloons("loonbalxballpoon");

        // assert
        assertEquals(2, result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new MaximumNumberOfBalloons();

        // act
        var result = solution.maxNumberOfBalloons("leetcode");

        // assert
        assertEquals(0, result);
    }
}
