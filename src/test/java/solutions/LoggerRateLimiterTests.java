package solutions;

import org.junit.Assert;
import org.junit.Test;

public class LoggerRateLimiterTests {

    @Test
    public void testExample1() {
        var logger = new LoggerRateLimiter();

        // logging string "foo" at timestamp 1
        Assert.assertTrue(logger.shouldPrintMessage(1, "foo"));

        // logging string "bar" at timestamp 2
        Assert.assertTrue(logger.shouldPrintMessage(2,"bar"));

        // logging string "foo" at timestamp 3
        Assert.assertFalse(logger.shouldPrintMessage(3,"foo"));

        // logging string "bar" at timestamp 8
        Assert.assertFalse(logger.shouldPrintMessage(8,"bar"));

        // logging string "foo" at timestamp 10
        Assert.assertFalse(logger.shouldPrintMessage(10,"foo"));

        // logging string "foo" at timestamp 11
        Assert.assertTrue(logger.shouldPrintMessage(11,"foo"));
    }
}
