package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class MinStackTests {

    @Test public void testExample() {
        var minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertEquals(-3, minStack.getMin());
        minStack.pop();
        assertEquals(0, minStack.top());
        assertEquals(-2, minStack.getMin());
    }
}
