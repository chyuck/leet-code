package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReverseLinkedListTests {

    @Test public void testExampleForIterativeSolution() {
        // arrange
        var solution = new ReverseLinkedList();

        var list = solution.new ListNode(1,
                solution.new ListNode(2,
                        solution.new ListNode(3,
                                solution.new ListNode(4,
                                        solution.new ListNode(5)))));

        // act
        var result = solution.reverseList(list);

        // assert
        assertEquals("5->4->3->2->1", printLinkedList(result));
    }

    private String printLinkedList(ReverseLinkedList.ListNode node) {
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
