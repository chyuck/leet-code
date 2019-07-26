package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class IntersectionOfTwoLinkedListsTests {

    @Test public void testExample1() {
        // arrange
        var solution = new IntersectionOfTwoLinkedLists();

        var linkedList1 = solution.new ListNode(4);
        linkedList1.next = solution.new ListNode(1);
        linkedList1.next.next = solution.new ListNode(8);
        linkedList1.next.next.next = solution.new ListNode(4);
        linkedList1.next.next.next.next = solution.new ListNode(5);

        var linkedList2 = solution.new ListNode(5);
        linkedList2.next = solution.new ListNode(0);
        linkedList2.next.next = solution.new ListNode(1);
        linkedList2.next.next.next = linkedList1.next.next;

        // act
        var result = solution.getIntersectionNode(linkedList1, linkedList2);

        // assert
        assertEquals(linkedList1.next.next, result);
    }

    @Test public void testExample2() {
        // arrange
        var solution = new IntersectionOfTwoLinkedLists();

        var linkedList1 = solution.new ListNode(0);
        linkedList1.next = solution.new ListNode(9);
        linkedList1.next.next = solution.new ListNode(1);
        linkedList1.next.next.next = solution.new ListNode(2);
        linkedList1.next.next.next.next = solution.new ListNode(4);

        var linkedList2 = solution.new ListNode(3);
        linkedList2.next = linkedList1.next.next.next;

        // act
        var result = solution.getIntersectionNode(linkedList1, linkedList2);

        // assert
        assertEquals(linkedList1.next.next.next, result);
    }

    @Test public void testExample3() {
        // arrange
        var solution = new IntersectionOfTwoLinkedLists();

        var linkedList1 = solution.new ListNode(2);
        linkedList1.next = solution.new ListNode(6);
        linkedList1.next.next = solution.new ListNode(4);

        var linkedList2 = solution.new ListNode(1);
        linkedList2.next = solution.new ListNode(5);

        // act
        var result = solution.getIntersectionNode(linkedList1, linkedList2);

        // assert
        assertNull(result);
    }
}
