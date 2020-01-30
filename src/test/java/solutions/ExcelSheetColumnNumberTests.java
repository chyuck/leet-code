package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExcelSheetColumnNumberTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new ExcelSheetColumnNumber();

        // act
        var result = solution.titleToNumber("A");

        // assert
        assertEquals(1, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new ExcelSheetColumnNumber();

        // act
        var result = solution.titleToNumber("AB");

        // assert
        assertEquals(28, result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new ExcelSheetColumnNumber();

        // act
        var result = solution.titleToNumber("ZY");

        // assert
        assertEquals(701, result);
    }
}
