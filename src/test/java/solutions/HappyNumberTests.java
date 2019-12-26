package solutions;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HappyNumberTests {

    @Test public void testExampleForSolution1() {
        // arrange
        var solution = new HappyNumber();

        // act
        var result = solution.isHappy(19);

        // assert
        assertTrue(result);
    }

    @Test public void testExampleForSolution2() {
        // arrange
        var solution = new HappyNumber();

        // act
        var result = solution.isHappy2(19);

        // assert
        assertTrue(result);
    }
}
