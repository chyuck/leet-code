package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class MergeKSortedListsTests {

    @Test public void testExampleForSolution1() {
        // arrange
        final var solution = new MergeKSortedLists();

        final var input = new MergeKSortedLists.ListNode[] {
            solution.new ListNode(1, solution.new ListNode(4, solution.new ListNode(5))),
            solution.new ListNode(1, solution.new ListNode(3, solution.new ListNode(4))),
            solution.new ListNode(2, solution.new ListNode(6))
        };

        // act
        final var result = solution.mergeKLists(input);

        // assert
        assertEquals("1->1->2->3->4->4->5->6", printLinkedList(result));
    }

    @Test public void testExampleForSolution2() {
        // arrange
        final var solution = new MergeKSortedLists();

        final var input = new MergeKSortedLists.ListNode[] {
            solution.new ListNode(1, solution.new ListNode(4, solution.new ListNode(5))),
            solution.new ListNode(1, solution.new ListNode(3, solution.new ListNode(4))),
            solution.new ListNode(2, solution.new ListNode(6))
        };

        // act
        final var result = solution.mergeKLists2(input);

        // assert
        assertEquals("1->1->2->3->4->4->5->6", printLinkedList(result));
    }

    private String printLinkedList(MergeKSortedLists.ListNode node) {
        if (node == null)
            return "";

        final var stringBuilder = new StringBuilder();

        while (node != null) {
            stringBuilder.append(node.val);

            if (node.next != null) {
                stringBuilder.append("->");
            }

            node = node.next;
        }

        return stringBuilder.toString();
    }
}
