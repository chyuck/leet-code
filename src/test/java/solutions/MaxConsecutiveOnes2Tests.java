package solutions;

import org.junit.Assert;
import org.junit.Test;

public class MaxConsecutiveOnes2Tests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new MaxConsecutiveOnes2();

        // act
        var result = solution.findMaxConsecutiveOnes(new int[] {1,0,1,1,0});

        // assert
        Assert.assertEquals(4, result);
    }
}
