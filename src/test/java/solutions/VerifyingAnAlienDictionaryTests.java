package solutions;

import org.junit.Assert;
import org.junit.Test;

public class VerifyingAnAlienDictionaryTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new VerifyingAnAlienDictionary();

        // act
        var result = solution.isAlienSorted(new String[] { "hello","leetcode" }, "hlabcdefgijkmnopqrstuvwxyz");

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new VerifyingAnAlienDictionary();

        // act
        var result = solution.isAlienSorted(new String[] { "word","world","row" }, "worldabcefghijkmnpqstuvxyz");

        // assert
        Assert.assertFalse(result);
    }

    @Test
    public void testExample3(){
        // arrange
        var solution = new VerifyingAnAlienDictionary();

        // act
        var result = solution.isAlienSorted(new String[] { "apple","app" }, "abcdefghijklmnopqrstuvwxyz");

        // assert
        Assert.assertFalse(result);
    }
}
