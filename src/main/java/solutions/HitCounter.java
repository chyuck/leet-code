package solutions;

/**
 * Solution for https://leetcode.com/problems/design-hit-counter/ problem with
 * Space complexity: O(T)
 * where T - window size in seconds
 */
public class HitCounter {

    private static class Hit {
        int timestamp = 0;
        int count = 0;
    }

    private static final int WINDOW_SIZE_IN_SECONDS = 300;

    private final Hit[] hits = new Hit[WINDOW_SIZE_IN_SECONDS];

    /** Initialize your data structure here. */
    public HitCounter() {
        for (int i = 0; i < hits.length; i++) {
            hits[i] = new Hit();
        }
    }

    /**
     * Record a hit.
     * @param timestamp - The current timestamp (in seconds granularity).
     * Time complexity: O(1)
     */
    public void hit(int timestamp) {
        int key = timestamp % WINDOW_SIZE_IN_SECONDS;
        Hit hit = hits[key];

        if (hit.timestamp == timestamp) {
            hit.count++;
        } else {
            hit.timestamp = timestamp;
            hit.count = 1;
        }
    }

    /**
     * Return the number of hits in the past 5 minutes.
     * @param timestamp - The current timestamp (in seconds granularity).
     * Time complexity: O(T)
     */
    public int getHits(int timestamp) {
        int minTimestamp = Math.max(0, timestamp - WINDOW_SIZE_IN_SECONDS);

        int result = 0;

        for (Hit hit : hits) {
            if (hit.timestamp > minTimestamp) {
                result += hit.count;
            }
        }

        return result;
    }
}
