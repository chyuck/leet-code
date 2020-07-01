package solutions;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfConnectedComponentsInGraphTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new NumberOfConnectedComponentsInGraph();

        // act
        var result = solution.countComponents(5, new int[][] { {0,1}, {1,2}, {3,4} });

        // assert
        Assert.assertEquals(2, result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new NumberOfConnectedComponentsInGraph();

        // act
        var result = solution.countComponents(5, new int[][] { {0,1}, {1,2}, {2,3}, {3,4} });

        // assert
        Assert.assertEquals(1, result);
    }

    @Test
    public void testCase1(){
        // arrange
        var solution = new NumberOfConnectedComponentsInGraph();

        // act
        var result = solution.countComponents(2, new int[][] { {1,0} });

        // assert
        Assert.assertEquals(1, result);
    }

    @Test
    public void testCase2(){
        // arrange
        var solution = new NumberOfConnectedComponentsInGraph();

        // act
        var result = solution.countComponents(3, new int[][] { {2,0}, {2,1} });

        // assert
        Assert.assertEquals(1, result);
    }
}
