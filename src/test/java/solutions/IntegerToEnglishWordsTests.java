package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class IntegerToEnglishWordsTests {

    @Test public void testExample1() {
        // arrange
        final var solution = new IntegerToEnglishWords();

        // act
        final var result = solution.numberToWords(123);

        // assert
        assertEquals("One Hundred Twenty Three", result);
    }

    @Test public void testExample2() {
        // arrange
        final var solution = new IntegerToEnglishWords();

        // act
        final var result = solution.numberToWords(12345);

        // assert
        assertEquals("Twelve Thousand Three Hundred Forty Five", result);
    }

    @Test public void testExample3() {
        // arrange
        final var solution = new IntegerToEnglishWords();

        // act
        final var result = solution.numberToWords(1234567);

        // assert
        assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven", result);
    }

    @Test public void testExample4() {
        // arrange
        final var solution = new IntegerToEnglishWords();

        // act
        final var result = solution.numberToWords(1234567891);

        // assert
        assertEquals("One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One", result);
    }
}
