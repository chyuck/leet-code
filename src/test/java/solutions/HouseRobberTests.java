package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HouseRobberTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new HouseRobber();

        // act
        var result = solution.rob(new int[] { 1,2,3,1 });

        // assert
        assertEquals(4, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new HouseRobber();

        // act
        var result = solution.rob(new int[] { 2,7,9,3,1 });

        // assert
        assertEquals(12, result);
    }
}
