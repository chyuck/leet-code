package solutions;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ExclusiveTimeOfFunctionsTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new ExclusiveTimeOfFunctions();

        // act
        var result = solution.exclusiveTime(2, Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6"));

        // assert
        Assert.assertArrayEquals(new int[] {3,4}, result);
    }

    @Test
    public void testCase1(){
        // arrange
        var solution = new ExclusiveTimeOfFunctions();

        // act
        var result = solution.exclusiveTime(1,
            Arrays.asList("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"));

        // assert
        Assert.assertArrayEquals(new int[] {8}, result);
    }

    @Test
    public void testCase2(){
        // arrange
        var solution = new ExclusiveTimeOfFunctions();

        // act
        var result = solution.exclusiveTime(3,
            Arrays.asList("0:start:0","0:end:0","1:start:1","1:end:1","2:start:2","2:end:2","2:start:3","2:end:3"));

        // assert
        Assert.assertArrayEquals(new int[] {1,1,2}, result);
    }
}
