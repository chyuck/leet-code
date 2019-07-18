package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class JewelsAndStonesTests {

    @Test public void testExample1() {
        // arrange
        var solution = new JewelsAndStones();

        // act
        var result = solution.numJewelsInStones("aA", "aAAbbbb");

        // assert
        assertEquals(3, result);
    }

    @Test public void testExample2() {
        // arrange
        var solution = new JewelsAndStones();

        // act
        var result = solution.numJewelsInStones("z", "ZZ");

        // assert
        assertEquals(0, result);
    }
}
