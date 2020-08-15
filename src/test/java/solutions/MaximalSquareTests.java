package solutions;

import org.junit.Assert;
import org.junit.Test;

public class MaximalSquareTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new MaximalSquare();

        char[][] matrix = new char[][] {
            { '1', '0', '1', '0', '0' },
            { '1', '0', '1', '1', '1' },
            { '1', '1', '1', '1', '1' },
            { '1', '0', '0', '1', '0' }};

        // act
        var result = solution.maximalSquare(matrix);

        // assert
        Assert.assertEquals(4, result);
    }

    @Test
    public void testCase1(){
        // arrange
        var solution = new MaximalSquare();

        char[][] matrix = new char[][] {{ '0', '1'}};

        // act
        var result = solution.maximalSquare(matrix);

        // assert
        Assert.assertEquals(1, result);
    }

    @Test
    public void testCase2(){
        // arrange
        var solution = new MaximalSquare();

        char[][] matrix = new char[][] {
            { '1', '1'},
            { '1', '1'}};

        // act
        var result = solution.maximalSquare(matrix);

        // assert
        Assert.assertEquals(4, result);
    }
}
