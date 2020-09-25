package solutions;

import org.junit.Assert;
import org.junit.Test;

public class DivideArrayInSetsOfKConsecutiveNumbersTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new DivideArrayInSetsOfKConsecutiveNumbers();

        // act
        var result = solution.isPossibleDivide(new int[] { 1,2,3,3,4,4,5,6 }, 4);

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new DivideArrayInSetsOfKConsecutiveNumbers();

        // act
        var result = solution.isPossibleDivide(new int[] { 3,2,1,2,3,4,3,4,5,9,10,11 }, 3);

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new DivideArrayInSetsOfKConsecutiveNumbers();

        // act
        var result = solution.isPossibleDivide(new int[] { 3,3,2,2,1,1 }, 3);

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample4() {
        // arrange
        var solution = new DivideArrayInSetsOfKConsecutiveNumbers();

        // act
        var result = solution.isPossibleDivide(new int[] { 1,2,3,4 }, 3);

        // assert
        Assert.assertFalse(result);
    }
}
