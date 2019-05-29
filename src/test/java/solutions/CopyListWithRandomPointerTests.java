package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class CopyListWithRandomPointerTests {

    @Test public void testExample1ForImplementation1() {
        // arrange
        var solution = new CopyListWithRandomPointer();

        var node1 = solution.new Node();
        var node2 = solution.new Node();

        node1.val = 1;
        node1.next = node2;
        node1.random = node2;

        node2.val = 2;
        node2.next = null;
        node2.random = node2;

        // act
        var result1 = solution.copyRandomList(node1);

        // assert
        assertNotEquals(node1, result1);
        assertEquals(node1.val, result1.val);
        var result2 = result1.next;
        assertNotNull(result2);
        assertEquals(result1.random, result2);

        assertNotEquals(node2, result2);
        assertEquals(node2.val, result2.val);
        assertNull(result2.next);
        assertEquals(result2, result2.random);
    }

    @Test public void testExample1ForImplementation2() {
        // arrange
        var solution = new CopyListWithRandomPointer();

        var node1 = solution.new Node();
        var node2 = solution.new Node();

        node1.val = 1;
        node1.next = node2;
        node1.random = node2;

        node2.val = 2;
        node2.next = null;
        node2.random = node2;

        // act
        var result1 = solution.copyRandomList2(node1);

        // assert
        assertNotEquals(node1, result1);
        assertEquals(node1.val, result1.val);
        var result2 = result1.next;
        assertNotNull(result2);
        assertEquals(result1.random, result2);

        assertNotEquals(node2, result2);
        assertEquals(node2.val, result2.val);
        assertNull(result2.next);
        assertEquals(result2, result2.random);
    }

    @Test public void testExample1ForImplementation3() {
        // arrange
        var solution = new CopyListWithRandomPointer();

        var node1 = solution.new Node();
        var node2 = solution.new Node();

        node1.val = 1;
        node1.next = node2;
        node1.random = node2;

        node2.val = 2;
        node2.next = null;
        node2.random = node2;

        // act
        var result1 = solution.copyRandomList3(node1);

        // assert
        assertNotEquals(node1, result1);
        assertEquals(node1.val, result1.val);
        var result2 = result1.next;
        assertNotNull(result2);
        assertEquals(result1.random, result2);

        assertNotEquals(node2, result2);
        assertEquals(node2.val, result2.val);
        assertNull(result2.next);
        assertEquals(result2, result2.random);
    }
}
