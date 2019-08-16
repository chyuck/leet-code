package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class SetMatrixZeroesTests {

    @Test public void testExample1() {
        // arrange
        var matrix = new int[][] {
            {1,1,1},
            {1,0,1},
            {1,1,1}};

        var solution = new SetMatrixZeroes();

        // act
        solution.setZeroes(matrix);

        // assert
        assertArrayEquals(
            new int[][] {
                {1,0,1},
                {0,0,0},
                {1,0,1}},
            matrix
        );
    }

    @Test public void testExample2() {
        // arrange
        var matrix = new int[][] {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}};

        var solution = new SetMatrixZeroes();

        // act
        solution.setZeroes(matrix);

        // assert
        assertArrayEquals(
                new int[][] {
                    {0,0,0,0},
                    {0,4,5,0},
                    {0,3,1,0}},
                matrix
        );
    }
}
