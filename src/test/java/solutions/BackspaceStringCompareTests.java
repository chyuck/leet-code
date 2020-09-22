package solutions;

import org.junit.Assert;
import org.junit.Test;

public class BackspaceStringCompareTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new BackspaceStringCompare();

        // act
        var result = solution.backspaceCompare("ab#c", "ad#c");

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new BackspaceStringCompare();

        // act
        var result = solution.backspaceCompare("ab##", "c#d#");

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new BackspaceStringCompare();

        // act
        var result = solution.backspaceCompare("a##c", "#a#c");

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample4() {
        // arrange
        var solution = new BackspaceStringCompare();

        // act
        var result = solution.backspaceCompare("a#c", "b");

        // assert
        Assert.assertFalse(result);
    }
}
