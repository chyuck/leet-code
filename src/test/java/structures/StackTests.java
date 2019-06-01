package structures;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTests {

    @Test public void testStackOperations() {
        final var stack = new Stack<Integer>();

        assertTrue(stack.isEmpty());

        assertEquals((Integer)1, stack.push(1));
        assertFalse(stack.isEmpty());
        assertEquals((Integer)2, stack.push(2));

        assertEquals((Integer)3, stack.push(3));

        assertEquals((Integer)3, stack.peak());
        assertFalse(stack.isEmpty());
        assertEquals((Integer)3, stack.pop());
        assertFalse(stack.isEmpty());

        assertEquals((Integer)2, stack.pop());
        assertEquals((Integer)1, stack.pop());

        assertTrue(stack.isEmpty());
    }
}
