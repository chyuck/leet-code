package solutions;

/**
 * Solution for https://leetcode.com/problems/reverse-linked-list problem with
 * Time complexity: O(N)
 * Space complexity: O(1)
 * where N - number of nodes in the linked list
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;

        while (head != null) {
            ListNode curr = head;
            ListNode next = head.next;

            curr.next = prev;

            prev = curr;
            head = next;
        }

        return prev;
    }

    public class ListNode {
        public final int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this(val);
            this.next = next;
        }
    }
}
