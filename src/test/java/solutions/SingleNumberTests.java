package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingleNumberTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new SingleNumber();

        // act
        int result = solution.singleNumber(new int[] { 2,2,1 });

        // assert
        assertEquals(1, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new SingleNumber();

        // act
        int result = solution.singleNumber(new int[] { 4,1,2,1,2 });

        // assert
        assertEquals(4, result);
    }
}
