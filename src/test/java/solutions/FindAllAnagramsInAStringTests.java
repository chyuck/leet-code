package solutions;

import org.junit.Assert;
import org.junit.Test;

public class FindAllAnagramsInAStringTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new FindAllAnagramsInAString();

        // act
        var results = solution.findAnagrams("cbaebabacd", "abc");

        // assert
        Assert.assertArrayEquals(new Integer[] {0, 6}, results.toArray(new Integer[2]));
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new FindAllAnagramsInAString();

        // act
        var results = solution.findAnagrams("abab", "ab");

        // assert
        Assert.assertArrayEquals(new Integer[] {0, 1, 2}, results.toArray(new Integer[3]));
    }
}
