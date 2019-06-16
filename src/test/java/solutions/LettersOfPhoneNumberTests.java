package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class LettersOfPhoneNumberTests {

    @Test public void testExampleForSolution1() {
        // arrange
        var solution = new LettersOfPhoneNumber();

        // act
        var result = solution.letterCombinations("23");

        // assert
        assertArrayEquals(new Object[] { "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf" }, result.toArray());
    }
}
