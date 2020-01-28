package solutions;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PlusOneTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new PlusOne();

        // act
        var result = solution.plusOne(new int[] { 1,2,3 });

        // assert
        assertArrayEquals(new int[] { 1,2,4 }, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new PlusOne();

        // act
        var result = solution.plusOne(new int[] { 4,3,2,1 });

        // assert
        assertArrayEquals(new int[] { 4,3,2,2 }, result);
    }

    @Test
    public void testCase() {
        // arrange
        var solution = new PlusOne();

        // act
        var result = solution.plusOne(new int[] { 9,9 });

        // assert
        assertArrayEquals(new int[] { 1,0,0 }, result);
    }
}
