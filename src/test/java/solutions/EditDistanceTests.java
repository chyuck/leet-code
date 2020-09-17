package solutions;

import org.junit.Assert;
import org.junit.Test;

public class EditDistanceTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new EditDistance();

        // act
        var result = solution.minDistance("horse", "ros");

        // assert
        Assert.assertEquals(3, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new EditDistance();

        // act
        var result = solution.minDistance("intention", "execution");

        // assert
        Assert.assertEquals(5, result);
    }
}
