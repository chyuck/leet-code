package solutions;

import org.junit.Assert;
import org.junit.Test;

public class SparseMatrixMultiplicationTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new SparseMatrixMultiplication();

        var A = new int[][] {
            { 1,0,0 },
            {-1,0,3}};

        var B = new int[][] {
            { 7,0,0 },
            { 0,0,0},
            { 0,0,1}};

        // act
        var result = solution.multiply(A, B);

        // assert
        var expected = new int[][] {
            { 7,0,0 },
            {-7,0,3}};
        Assert.assertArrayEquals(expected, result);
    }
}
