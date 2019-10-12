package solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseScheduleTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new CourseSchedule();

        // act
        var result = solution.canFinish(2, new int[][] { { 1,0 } });

        // assert
        assertTrue(result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new CourseSchedule();

        // act
        var result = solution.canFinish(2, new int[][] { { 1,0 }, { 0, 1 } });

        // assert
        assertFalse(result);
    }
}
