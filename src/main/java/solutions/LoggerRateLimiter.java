package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/logger-rate-limiter/ problem with
 * Time complexity: O(1)
 * Space complexity: O(n)
 */
public class LoggerRateLimiter {

    private final Map<String, Integer> timestamps = new HashMap<>();

    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer existingTimestamp = timestamps.get(message);

        if (existingTimestamp == null || timestamp - existingTimestamp >= 10) {
            timestamps.put(message, timestamp);
            return true;
        }

        return false;
    }
}
