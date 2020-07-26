package solutions;

import org.junit.Assert;
import org.junit.Test;

public class MaxConsecutiveOnes3Tests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new MaxConsecutiveOnes3();

        // act
        var result = solution.longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2);

        // assert
        Assert.assertEquals(6, result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new MaxConsecutiveOnes3();

        // act
        var result = solution.longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3);

        // assert
        Assert.assertEquals(10, result);
    }
}
