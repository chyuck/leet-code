package solutions;

import org.junit.Assert;
import org.junit.Test;

public class MaximumPointsYouCanObtainFromCardsTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new MaximumPointsYouCanObtainFromCards();

        // act
        var result = solution.maxScore(new int[] { 1,2,3,4,5,6,1 }, 3);

        // assert
        Assert.assertEquals(12, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new MaximumPointsYouCanObtainFromCards();

        // act
        var result = solution.maxScore(new int[] { 2,2,2 }, 2);

        // assert
        Assert.assertEquals(4, result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new MaximumPointsYouCanObtainFromCards();

        // act
        var result = solution.maxScore(new int[] { 9,7,7,9,7,7,9 }, 7);

        // assert
        Assert.assertEquals(55, result);
    }

    @Test
    public void testExample4() {
        // arrange
        var solution = new MaximumPointsYouCanObtainFromCards();

        // act
        var result = solution.maxScore(new int[] { 1,1000,1 }, 1);

        // assert
        Assert.assertEquals(1, result);
    }

    @Test
    public void testExample5() {
        // arrange
        var solution = new MaximumPointsYouCanObtainFromCards();

        // act
        var result = solution.maxScore(new int[] { 1,79,80,1,1,1,200,1 }, 3);

        // assert
        Assert.assertEquals(202, result);
    }
}
