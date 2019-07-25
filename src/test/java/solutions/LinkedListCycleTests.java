package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListCycleTests {

    @Test public void testExample1() {
        // arrange
        var solution = new LinkedListCycle();

        var linkedList = solution.new ListNode(3);
        linkedList.next = solution.new ListNode(2);
        linkedList.next.next = solution.new ListNode(0);
        linkedList.next.next.next = solution.new ListNode(-4);
        linkedList.next.next.next.next = linkedList.next;

        // act
        var result = solution.hasCycle(linkedList);

        // assert
        assertTrue(result);
    }

    @Test public void testExample2() {
        // arrange
        var solution = new LinkedListCycle();

        var linkedList = solution.new ListNode(1);
        linkedList.next = solution.new ListNode(2);
        linkedList.next.next = linkedList;

        // act
        var result = solution.hasCycle(linkedList);

        // assert
        assertTrue(result);
    }

    @Test public void testExample3() {
        // arrange
        var solution = new LinkedListCycle();

        var linkedList = solution.new ListNode(1);

        // act
        var result = solution.hasCycle(linkedList);

        // assert
        assertFalse(result);
    }
}
