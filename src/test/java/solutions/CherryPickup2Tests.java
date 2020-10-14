package solutions;

import org.junit.Assert;
import org.junit.Test;

public class CherryPickup2Tests {

    @Test
    public void testExample1() {
        // arrange
        var grid = new int[][] {
            {3,1,1},
            {2,5,1},
            {1,5,5},
            {2,1,1}};

        var solution = new CherryPickup2();

        // act
        var result = solution.cherryPickup(grid);

        // assert
        Assert.assertEquals(24, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var grid = new int[][] {
            {1,0,0,0,0,0,1},
            {2,0,0,0,0,3,0},
            {2,0,9,0,0,0,0},
            {0,3,0,5,4,0,0},
            {1,0,2,3,0,0,6}};

        var solution = new CherryPickup2();

        // act
        var result = solution.cherryPickup(grid);

        // assert
        Assert.assertEquals(28, result);
    }

    @Test
    public void testExample3() {
        // arrange
        var grid = new int[][] {
            {1,0,0,3},
            {0,0,0,3},
            {0,0,3,3},
            {9,0,3,3}};

        var solution = new CherryPickup2();

        // act
        var result = solution.cherryPickup(grid);

        // assert
        Assert.assertEquals(22, result);
    }

    @Test
    public void testExample4() {
        // arrange
        var grid = new int[][] {
            {1,1},
            {1,1}};

        var solution = new CherryPickup2();

        // act
        var result = solution.cherryPickup(grid);

        // assert
        Assert.assertEquals(4, result);
    }
}
