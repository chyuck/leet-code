package solutions;

import org.junit.Assert;
import org.junit.Test;

public class LongestStringChainTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new LongestStringChain();

        // act
        var result = solution.longestStrChain(new String[] { "a","b","ba","bca","bda","bdca" });

        // assert
        Assert.assertEquals(4, result);
    }
}
