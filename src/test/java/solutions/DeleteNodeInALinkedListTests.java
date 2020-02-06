package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DeleteNodeInALinkedListTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new DeleteNodeInALinkedList();

        var linkedList =
            solution.new ListNode(4,
                solution.new ListNode(5,
                    solution.new ListNode(1,
                        solution.new ListNode(9))));

        // act
        solution.deleteNode(linkedList.next);

        // assert
        assertEquals(4, linkedList.val);
        assertEquals(1, linkedList.next.val);
        assertEquals(9, linkedList.next.next.val);
        assertNull(linkedList.next.next.next);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new DeleteNodeInALinkedList();

        var linkedList =
            solution.new ListNode(4,
                solution.new ListNode(5,
                    solution.new ListNode(1,
                        solution.new ListNode(9))));

        // act
        solution.deleteNode(linkedList.next.next);

        // assert
        assertEquals(4, linkedList.val);
        assertEquals(5, linkedList.next.val);
        assertEquals(9, linkedList.next.next.val);
        assertNull(linkedList.next.next.next);
    }
}
