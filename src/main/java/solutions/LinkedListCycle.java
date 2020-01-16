package solutions;

/**
 * Solution for https://leetcode.com/problems/linked-list-cycle problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow.val == fast.val) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    public class ListNode {
        final int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
