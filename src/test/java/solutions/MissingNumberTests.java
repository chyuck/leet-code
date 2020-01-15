package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MissingNumberTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new MissingNumber();

        // act
        final var result = solution.missingNumber(new int[] { 3,0,1 });

        // assert
        assertEquals(2, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new MissingNumber();

        // act
        final var result = solution.missingNumber(new int[] { 9,6,4,2,3,5,7,0,1 });

        // assert
        assertEquals(8, result);
    }
}
