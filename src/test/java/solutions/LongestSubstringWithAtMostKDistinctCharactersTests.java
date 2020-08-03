package solutions;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringWithAtMostKDistinctCharactersTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new LongestSubstringWithAtMostKDistinctCharacters();

        // act
        var result = solution.lengthOfLongestSubstringKDistinct("eceba", 2);

        // assert
        Assert.assertEquals(3, result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new LongestSubstringWithAtMostKDistinctCharacters();

        // act
        var result = solution.lengthOfLongestSubstringKDistinct("aa", 1);

        // assert
        Assert.assertEquals(2, result);
    }

    @Test
    public void testCase1(){
        // arrange
        var solution = new LongestSubstringWithAtMostKDistinctCharacters();

        // act
        var result = solution.lengthOfLongestSubstringKDistinct("aba", 1);

        // assert
        Assert.assertEquals(1, result);
    }
}
