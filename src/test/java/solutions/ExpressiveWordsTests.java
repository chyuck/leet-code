package solutions;

import org.junit.Assert;
import org.junit.Test;

public class ExpressiveWordsTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new ExpressiveWords();

        // act
        var result = solution.expressiveWords("heeellooo", new String[] { "hello", "hi", "helo" });

        // assert
        Assert.assertEquals(1, result);
    }
}
