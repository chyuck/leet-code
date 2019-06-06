package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class RotateImageTests {

    @Test public void testExample1() {
        // arrange
        final var matrix = new int[][] {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }};

        final var solution = new RotateImage();

        // act
        solution.rotate(matrix);

        // assert
        assertEquals(3, matrix.length);
        assertArrayEquals(new int[] { 7, 4, 1 }, matrix[0]);
        assertArrayEquals(new int[] { 8, 5, 2 }, matrix[1]);
        assertArrayEquals(new int[] { 9, 6, 3 }, matrix[2]);
    }

    @Test public void testExample2() {
        // arrange
        final var matrix = new int[][] {
            { 5, 1, 9, 11 },
            { 2, 4, 8, 10 },
            { 13, 3, 6, 7 },
            { 15, 14, 12, 16 }};

        final var solution = new RotateImage();

        // act
        solution.rotate(matrix);

        // assert
        assertEquals(4, matrix.length);
        assertArrayEquals(new int[] { 15, 13, 2, 5 }, matrix[0]);
        assertArrayEquals(new int[] { 14, 3, 4, 1 }, matrix[1]);
        assertArrayEquals(new int[] { 12, 6, 8, 9 }, matrix[2]);
        assertArrayEquals(new int[] { 16, 7, 10, 11 }, matrix[3]);
    }
}
