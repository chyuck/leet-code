package solutions;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TopKFrequentWordsTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new TopKFrequentWords();

        // act
        var result = solution.topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2);

        // assert
        assertArrayEquals(new String[] {"i", "love"}, result.toArray(new String[] {}));
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new TopKFrequentWords();

        // act
        var result = solution.topKFrequent(new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" }, 4);

        // assert
        assertArrayEquals(new String[] {"the", "is", "sunny", "day"}, result.toArray(new String[] {}));
    }

    @Test
    public void testCase1() {
        // arrange
        var solution = new TopKFrequentWords();

        // act
        var result = solution.topKFrequent(new String[] { "the", "day", "is", "sunny", "the",  "the", "sunny", "is", "is" }, 3);

        // assert
        assertArrayEquals(new String[] {"is", "the", "sunny"}, result.toArray(new String[] {}));
    }
}
