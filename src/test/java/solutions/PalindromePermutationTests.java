package solutions;

import org.junit.Assert;
import org.junit.Test;

public class PalindromePermutationTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new PalindromePermutation();

        // act
        var result = solution.canPermutePalindrome("code");

        // assert
        Assert.assertFalse(result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new PalindromePermutation();

        // act
        var result = solution.canPermutePalindrome("aab");

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample3(){
        // arrange
        var solution = new PalindromePermutation();

        // act
        var result = solution.canPermutePalindrome("carerac");

        // assert
        Assert.assertTrue(result);
    }
}
