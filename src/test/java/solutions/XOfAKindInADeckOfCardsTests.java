package solutions;

import org.junit.Assert;
import org.junit.Test;

public class XOfAKindInADeckOfCardsTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new XOfAKindInADeckOfCards();

        // act
        var result = solution.hasGroupsSizeX(new int[] {1,2,3,4,4,3,2,1});

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new XOfAKindInADeckOfCards();

        // act
        var result = solution.hasGroupsSizeX(new int[] {1,1,1,2,2,2,3,3});

        // assert
        Assert.assertFalse(result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new XOfAKindInADeckOfCards();

        // act
        var result = solution.hasGroupsSizeX(new int[] {1});

        // assert
        Assert.assertFalse(result);
    }

    @Test
    public void testExample4() {
        // arrange
        var solution = new XOfAKindInADeckOfCards();

        // act
        var result = solution.hasGroupsSizeX(new int[] {1,1});

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample5() {
        // arrange
        var solution = new XOfAKindInADeckOfCards();

        // act
        var result = solution.hasGroupsSizeX(new int[] {1,1,2,2,2,2});

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testCase1() {
        // arrange
        var solution = new XOfAKindInADeckOfCards();

        // act
        var result = solution.hasGroupsSizeX(new int[] {1,1,1,1,2,2,2,2,2,2});

        // assert
        Assert.assertTrue(result);
    }
}
