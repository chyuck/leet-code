package solutions;

import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedArrayTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new SearchInRotatedSortedArray();

        // act
        var result = solution.search(new int[] {4,5,6,7,0,1,2}, 0);

        // assert
        Assert.assertEquals(4, result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new SearchInRotatedSortedArray();

        // act
        var result = solution.search(new int[] {4,5,6,7,0,1,2}, 3);

        // assert
        Assert.assertEquals(-1, result);
    }
}
