package solutions;

import org.junit.Assert;
import org.junit.Test;

public class MissingElementInSortedArrayTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new MissingElementInSortedArray();

        // act
        var result = solution.missingElement(new int[] { 4,7,9,10 }, 1);

        // assert
        Assert.assertEquals(5, result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new MissingElementInSortedArray();

        // act
        var result = solution.missingElement(new int[] { 4,7,9,10 }, 3);

        // assert
        Assert.assertEquals(8, result);
    }

    @Test
    public void testExample3(){
        // arrange
        var solution = new MissingElementInSortedArray();

        // act
        var result = solution.missingElement(new int[] { 1,2,4 }, 3);

        // assert
        Assert.assertEquals(6, result);
    }
}
