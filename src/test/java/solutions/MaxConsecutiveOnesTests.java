package solutions;

import org.junit.Assert;
import org.junit.Test;

public class MaxConsecutiveOnesTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new MaxConsecutiveOnes();

        // act
        var result = solution.findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1});

        // assert
        Assert.assertEquals(3, result);
    }
}
