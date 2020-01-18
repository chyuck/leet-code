package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MajorityElementTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new MajorityElement();

        // act
        var result = solution.majorityElement(new int[] { 3,2,3 });

        // assert
        assertEquals(3, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new MajorityElement();

        // act
        var result = solution.majorityElement(new int[] { 2,2,1,1,1,2,2 });

        // assert
        assertEquals(2, result);
    }
}
