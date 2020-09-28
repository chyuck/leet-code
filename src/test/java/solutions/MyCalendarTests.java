package solutions;

import org.junit.Assert;
import org.junit.Test;

public class MyCalendarTests {

    @Test
    public void testExample1() {
        var solution = new MyCalendar();

        Assert.assertTrue(solution.book(10, 20));
        Assert.assertFalse(solution.book(15, 25));
        Assert.assertTrue(solution.book(20, 30));
    }
}
