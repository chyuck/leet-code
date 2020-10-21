package solutions;

import org.junit.Assert;
import org.junit.Test;

public class CountSubmatricesWithAllOnesTests {

    @Test
    public void testExample1() {
        // arrange
        var mat = new int[][] {
            {1,0,1},
            {1,1,0},
            {1,1,0}};

        var solution = new CountSubmatricesWithAllOnes();

        // act
        var result = solution.numSubmat(mat);

        // assert
        Assert.assertEquals(13, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var mat = new int[][] {
            {0,1,1,0},
            {0,1,1,1},
            {1,1,1,0}};

        var solution = new CountSubmatricesWithAllOnes();

        // act
        var result = solution.numSubmat(mat);

        // assert
        Assert.assertEquals(24, result);
    }

    @Test
    public void testExample3() {
        // arrange
        var mat = new int[][] {{1,1,1,1,1,1}};

        var solution = new CountSubmatricesWithAllOnes();

        // act
        var result = solution.numSubmat(mat);

        // assert
        Assert.assertEquals(21, result);
    }

    @Test
    public void testExample4() {
        // arrange
        var mat = new int[][] {
            {1,0,1},
            {0,1,0},
            {1,0,1}};

        var solution = new CountSubmatricesWithAllOnes();

        // act
        var result = solution.numSubmat(mat);

        // assert
        Assert.assertEquals(5, result);
    }
}
