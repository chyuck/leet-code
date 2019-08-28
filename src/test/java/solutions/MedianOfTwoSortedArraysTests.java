package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class MedianOfTwoSortedArraysTests {

    @Test public void testExample1() {
        // arrange
        var solution = new MedianOfTwoSortedArrays();

        // act
        var result = solution.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 });

        // assert
        assertEquals(2.0, result, 0.001);
    }

    @Test public void testExample2() {
        // arrange
        var solution = new MedianOfTwoSortedArrays();

        // act
        var result = solution.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 });

        // assert
        assertEquals(2.5, result, 0.001);
    }

    @Test public void testCase1() {
        // arrange
        var solution = new MedianOfTwoSortedArrays();

        // act
        var result = solution.findMedianSortedArrays(new int[] { 2 }, new int[] { });

        // assert
        assertEquals(2.0, result, 0.001);
    }
}
