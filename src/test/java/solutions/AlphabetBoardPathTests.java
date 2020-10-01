package solutions;

import org.junit.Assert;
import org.junit.Test;

public class AlphabetBoardPathTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new AlphabetBoardPath();

        // act
        var result = solution.alphabetBoardPath("leet");

        // assert
        Assert.assertEquals("DDR!UURRR!!DDD!", result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new AlphabetBoardPath();

        // act
        var result = solution.alphabetBoardPath("code");

        // assert
        Assert.assertEquals("RR!DDRR!UUL!R!", result);
    }

    @Test
    public void testCase1() {
        // arrange
        var solution = new AlphabetBoardPath();

        // act
        var result = solution.alphabetBoardPath("zdz");

        // assert
        Assert.assertEquals("DDDDD!UUUUURRR!DDDDLLLD!", result);
    }
}
