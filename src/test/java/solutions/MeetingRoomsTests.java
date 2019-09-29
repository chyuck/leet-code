package solutions;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MeetingRoomsTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new MeetingRooms();

        // act
        var result = solution.canAttendMeetings(new int[][] { {0, 30}, { 5, 10 }, { 15, 20 } });

        // assert
        assertFalse(result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new MeetingRooms();

        // act
        var result = solution.canAttendMeetings(new int[][] { {7, 10}, { 2, 4 } });

        // assert
        assertTrue(result);
    }
}
