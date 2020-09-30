package solutions;

import org.junit.Assert;
import org.junit.Test;

public class FindAndReplaceInStringTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new FindAndReplaceInString();

        // act
        var result = solution.findReplaceString("abcd", new int[] { 0, 2 }, new String[] { "a", "cd" }, new String[] { "eee", "ffff" });

        // assert
        Assert.assertEquals("eeebffff", result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new FindAndReplaceInString();

        // act
        var result = solution.findReplaceString("abcd", new int[] { 0, 2 }, new String[] { "ab", "ec" }, new String[] { "eee", "ffff" });

        // assert
        Assert.assertEquals("eeecd", result);
    }
}
