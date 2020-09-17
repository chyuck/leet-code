package solutions;

import org.junit.Assert;
import org.junit.Test;

public class ValidateStackSequencesTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new ValidateStackSequences();

        // act
        var result = solution.validateStackSequences(new int[] { 1,2,3,4,5 }, new int[] { 4,5,3,2,1 });

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new ValidateStackSequences();

        // act
        var result = solution.validateStackSequences(new int[] { 1,2,3,4,5 }, new int[] { 4,3,5,1,2 });

        // assert
        Assert.assertFalse(result);
    }
}
