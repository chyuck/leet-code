package solutions;

import org.junit.Assert;
import org.junit.Test;

public class FindFirstAndLastPositionOfElementInSortedArrayTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new FindFirstAndLastPositionOfElementInSortedArray();

        // act
        var result = solution.searchRange(new int[] { 5,7,7,8,8,10 }, 8);

        // assert
        Assert.assertArrayEquals(new int[] { 3,4 }, result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new FindFirstAndLastPositionOfElementInSortedArray();

        // act
        var result = solution.searchRange(new int[] { 5,7,7,8,8,10 }, 6);

        // assert
        Assert.assertArrayEquals(new int[] { -1,-1 }, result);
    }

    @Test
    public void testCase1(){
        // arrange
        var solution = new FindFirstAndLastPositionOfElementInSortedArray();

        // act
        var result = solution.searchRange(new int[] { 2,2 }, 2);

        // assert
        Assert.assertArrayEquals(new int[] { 0,1 }, result);
    }
}
