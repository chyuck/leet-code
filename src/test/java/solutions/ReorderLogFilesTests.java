package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReorderLogFilesTests {

    @Test public void testExample() {
        // arrange
        final var solution = new ReorderLogFiles();

        final var input = new String[] { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo" };

        // act
        final var result = solution.reorderLogFiles(input);

        // assert
        assertArrayEquals(new String[] { "g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7" }, result);
    }
}
