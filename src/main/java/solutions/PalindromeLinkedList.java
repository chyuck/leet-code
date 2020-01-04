package solutions;

/**
 * Solution for https://leetcode.com/problems/palindrome-linked-list problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class PalindromeLinkedList {

    public class ListNode {
        final int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public boolean isPalindrome(ListNode head) {
        int size = getSize(head);
        if (size <= 1) {
            return true;
        }

        ListNode[] twoLists = reverseFirstHalfAndSplitIntoTwoLists(size, head);

        return areListsEqual(twoLists[0], twoLists[1]);
    }

    private int getSize(ListNode head) {
        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }

    private ListNode[] reverseFirstHalfAndSplitIntoTwoLists(int size, ListNode head) {
        int halfSize = size / 2;

        ListNode curr = null;
        ListNode next = head;
        for (int i = 0; i < halfSize; i++) {
            ListNode next_next = next.next;
            next.next = curr;
            curr = next;
            next = next_next;
        }

        if (size % 2 == 1) {
            next = next.next;
        }

        return new ListNode[] { curr, next };
    }

    private boolean areListsEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        return l1 == null && l2 == null;
    }
}
