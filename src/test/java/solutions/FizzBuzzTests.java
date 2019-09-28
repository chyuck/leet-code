package solutions;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FizzBuzzTests {

    @Test
    public void testExample() {
        // arrange
        var solution = new FizzBuzz();

        // act
        var result = solution.fizzBuzz(15);

        // assert
        assertArrayEquals(new String[] { "1",
                "2",
                "Fizz",
                "4",
                "Buzz",
                "Fizz",
                "7",
                "8",
                "Fizz",
                "Buzz",
                "11",
                "Fizz",
                "13",
                "14",
                "FizzBuzz" }, result.toArray(new String[] {}));
    }
}
