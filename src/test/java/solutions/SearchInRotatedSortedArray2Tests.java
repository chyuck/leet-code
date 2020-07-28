package solutions;

import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedArray2Tests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new SearchInRotatedSortedArray2();

        // act
        var result = solution.search(new int[] {2,5,6,0,0,1,2}, 0);

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new SearchInRotatedSortedArray2();

        // act
        var result = solution.search(new int[] {2,5,6,0,0,1,2}, 3);

        // assert
        Assert.assertFalse(result);
    }

    @Test
    public void testCase1(){
        // arrange
        var solution = new SearchInRotatedSortedArray2();

        // act
        var result = solution.search(new int[] {1,3,1,1,1}, 3);

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testCase2(){
        // arrange
        var solution = new SearchInRotatedSortedArray2();

        // act
        var result = solution.search(new int[] {3,1}, 1);

        // assert
        Assert.assertTrue(result);
    }
}
