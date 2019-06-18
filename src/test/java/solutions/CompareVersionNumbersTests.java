package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class CompareVersionNumbersTests {

    @Test public void testExample1ForSolution1() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion("0.1", "1.1");

        // assert
        assertEquals(-1, result);
    }

    @Test public void testExample2ForSolution1() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion("1.0.1", "1");

        // assert
        assertEquals(1, result);
    }

    @Test public void testExample3ForSolution1() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion("7.5.2.4", "7.5.3");

        // assert
        assertEquals(-1, result);
    }

    @Test public void testExample4ForSolution1() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion("1.01", "1.001");

        // assert
        assertEquals(0, result);
    }

    @Test public void testExample5ForSolution1() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion("1.0", "1.0.0");

        // assert
        assertEquals(0, result);
    }

    @Test public void testCase1ForSolution1() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion("1.1", "1.10");

        // assert
        assertEquals(-1, result);
    }

    @Test public void testCase2ForSolution1() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion("1.2", "1.10");

        // assert
        assertEquals(-1, result);
    }

    @Test public void testExample1ForSolution2() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion2("0.1", "1.1");

        // assert
        assertEquals(-1, result);
    }

    @Test public void testExample2ForSolution2() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion2("1.0.1", "1");

        // assert
        assertEquals(1, result);
    }

    @Test public void testExample3ForSolution2() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion2("7.5.2.4", "7.5.3");

        // assert
        assertEquals(-1, result);
    }

    @Test public void testExample4ForSolution2() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion2("1.01", "1.001");

        // assert
        assertEquals(0, result);
    }

    @Test public void testExample5ForSolution2() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion2("1.0", "1.0.0");

        // assert
        assertEquals(0, result);
    }

    @Test public void testCase1ForSolution2() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion2("1.1", "1.10");

        // assert
        assertEquals(-1, result);
    }

    @Test public void testCase2ForSolution2() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion2("1.2", "1.10");

        // assert
        assertEquals(-1, result);
    }
}
