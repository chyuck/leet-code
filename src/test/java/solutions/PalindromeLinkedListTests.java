package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class PalindromeLinkedListTests {

    @Test public void testExample1() {
        // arrange
        var solution = new PalindromeLinkedList();

        var linkedList = solution.new ListNode(1);
        linkedList.next = solution.new ListNode(2);

        // act
        var result = solution.isPalindrome(linkedList);

        // assert
        assertFalse(result);
    }

    @Test public void testExample2() {
        // arrange
        var solution = new PalindromeLinkedList();

        var linkedList = solution.new ListNode(1);
        linkedList.next = solution.new ListNode(2);
        linkedList.next.next = solution.new ListNode(2);
        linkedList.next.next.next = solution.new ListNode(1);

        // act
        var result = solution.isPalindrome(linkedList);

        // assert
        assertTrue(result);
    }
}
