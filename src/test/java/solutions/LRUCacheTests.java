package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class LRUCacheTests {

    @Test public void testExample() {
        var cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        // returns 1
        assertEquals(1, cache.get(1));
        // evicts key 2
        cache.put(3, 3);
        // returns -1 (not found)
        assertEquals(-1, cache.get(2));
        // evicts key 1
        cache.put(4, 4);
        // returns -1 (not found)
        assertEquals(-1, cache.get(1));
        // returns 3
        assertEquals(3, cache.get(3));
        // returns 4
        assertEquals(4, cache.get(4));
    }
}
