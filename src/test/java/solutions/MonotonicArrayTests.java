package solutions;

import org.junit.Assert;
import org.junit.Test;

public class MonotonicArrayTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new MonotonicArray();

        // act
        var result = solution.isMonotonic(new int[] { 1,2,2,3 });

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new MonotonicArray();

        // act
        var result = solution.isMonotonic(new int[] { 6,5,4,4 });

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new MonotonicArray();

        // act
        var result = solution.isMonotonic(new int[] { 1,3,2 });

        // assert
        Assert.assertFalse(result);
    }

    @Test
    public void testExample4() {
        // arrange
        var solution = new MonotonicArray();

        // act
        var result = solution.isMonotonic(new int[] { 1,2,4,5 });

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample5() {
        // arrange
        var solution = new MonotonicArray();

        // act
        var result = solution.isMonotonic(new int[] { 1,1,1 });

        // assert
        Assert.assertTrue(result);
    }
}
