package solutions;

import org.junit.Assert;
import org.junit.Test;

public class InsertIntervalTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new InsertInterval();

        // act
        var result = solution.insert(new int[][] { {1,3}, {6,9} }, new int[] {2,5});

        // assert
        Assert.assertArrayEquals(new int[][] { {1,5}, {6,9} }, result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new InsertInterval();

        // act
        var result = solution.insert(new int[][] { {1,2}, {3,5}, {6,7}, {8,10}, {12,16} }, new int[] {4,8});

        // assert
        Assert.assertArrayEquals(new int[][] { {1,2}, {3,10}, {12,16} }, result);
    }

    @Test
    public void testCase1(){
        // arrange
        var solution = new InsertInterval();

        // act
        var result = solution.insert(new int[][] { {1,5} }, new int[] {2,7});

        // assert
        Assert.assertArrayEquals(new int[][] { {1,7} }, result);
    }
}
