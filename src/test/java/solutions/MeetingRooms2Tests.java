package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class MeetingRooms2Tests {

    @Test public void testExample1() {
        // arrange
        var solution = new MeetingRooms2();

        var intervals = new MeetingRooms2.Interval[] {
                solution.new Interval(0, 30),
                solution.new Interval(5, 10),
                solution.new Interval(15, 20)
        };

        // act
        var result = solution.minMeetingRooms(intervals);

        // assert
        assertEquals(2, result);
    }

    @Test public void testExample2() {
        // arrange
        var solution = new MeetingRooms2();

        var intervals = new MeetingRooms2.Interval[] {
                solution.new Interval(7, 10),
                solution.new Interval(2, 4)
        };

        // act
        var result = solution.minMeetingRooms(intervals);

        // assert
        assertEquals(1, result);
    }
}
