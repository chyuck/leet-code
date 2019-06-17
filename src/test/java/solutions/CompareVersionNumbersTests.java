package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class CompareVersionNumbersTests {

    @Test public void testExample1() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion("0.1", "1.1");

        // assert
        assertEquals(-1, result);
    }

    @Test public void testExample2() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion("1.0.1", "1");

        // assert
        assertEquals(1, result);
    }

    @Test public void testExample3() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion("7.5.2.4", "7.5.3");

        // assert
        assertEquals(-1, result);
    }

    @Test public void testExample4() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion("1.01", "1.001");

        // assert
        assertEquals(0, result);
    }

    @Test public void testExample5() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion("1.0", "1.0.0");

        // assert
        assertEquals(0, result);
    }

    @Test public void testCase1() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion("1.1", "1.10");

        // assert
        assertEquals(-1, result);
    }

    @Test public void testCase2() {
        // arrange
        var solution = new CompareVersionNumbers();

        // act
        var result = solution.compareVersion("1.2", "1.10");

        // assert
        assertEquals(-1, result);
    }
}
