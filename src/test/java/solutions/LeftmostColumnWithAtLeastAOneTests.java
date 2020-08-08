package solutions;

import org.junit.Assert;
import org.junit.Test;

public class LeftmostColumnWithAtLeastAOneTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new LeftmostColumnWithAtLeastAOne();

        var binaryMatrix = new LeftmostColumnWithAtLeastAOne.BinaryMatrix(new int[][] {
            {0,0},
            {1,1}
        });

        // act
        var result = solution.leftMostColumnWithOne(binaryMatrix);

        // assert
        Assert.assertEquals(0, result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new LeftmostColumnWithAtLeastAOne();

        var binaryMatrix = new LeftmostColumnWithAtLeastAOne.BinaryMatrix(new int[][] {
            {0,0},
            {0,1}
        });

        // act
        var result = solution.leftMostColumnWithOne(binaryMatrix);

        // assert
        Assert.assertEquals(1, result);
    }

    @Test
    public void testExample3(){
        // arrange
        var solution = new LeftmostColumnWithAtLeastAOne();

        var binaryMatrix = new LeftmostColumnWithAtLeastAOne.BinaryMatrix(new int[][] {
            {0,0},
            {0,0}
        });

        // act
        var result = solution.leftMostColumnWithOne(binaryMatrix);

        // assert
        Assert.assertEquals(-1, result);
    }

    @Test
    public void testExample4(){
        // arrange
        var solution = new LeftmostColumnWithAtLeastAOne();

        var binaryMatrix = new LeftmostColumnWithAtLeastAOne.BinaryMatrix(new int[][] {
            {0,0,0,1},
            {0,0,1,1},
            {0,1,1,1}
        });

        // act
        var result = solution.leftMostColumnWithOne(binaryMatrix);

        // assert
        Assert.assertEquals(1, result);
    }
}
