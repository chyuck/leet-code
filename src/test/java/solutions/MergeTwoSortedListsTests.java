package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class MergeTwoSortedListsTests {

    @Test public void testExample() {
        // arrange
        final var solution = new MergeTwoSortedLists();

        final var list1 = solution.new ListNode(1, solution.new ListNode(2, solution.new ListNode(4)));
        final var list2 = solution.new ListNode(1, solution.new ListNode(3, solution.new ListNode(4)));

        // act
        final var result = solution.mergeTwoLists(list1, list2);

        // assert
        assertEquals("1->1->2->3->4->4", printLinkedList(result));
    }

    private String printLinkedList(MergeTwoSortedLists.ListNode node) {
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
