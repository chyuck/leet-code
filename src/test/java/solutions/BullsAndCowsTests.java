package solutions;

import org.junit.Assert;
import org.junit.Test;

public class BullsAndCowsTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new BullsAndCows();

        // act
        var result = solution.getHint("1807", "7810");

        // assert
        Assert.assertEquals("1A3B", result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new BullsAndCows();

        // act
        var result = solution.getHint("1123", "0111");

        // assert
        Assert.assertEquals("1A1B", result);
    }

    @Test
    public void testCase1() {
        // arrange
        var solution = new BullsAndCows();

        // act
        var result = solution.getHint("1122", "1222");

        // assert
        Assert.assertEquals("3A0B", result);
    }
}
