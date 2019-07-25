package solutions;

/**
 * Solution for https://leetcode.com/problems/palindrome-linked-list problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        // zero or one node linked lists are palindromes
        if (head == null) return true;
        if (head.next == null) return true;

        // calculate number of nodes
        int count = 0;
        ListNode pointer = head;
        while (pointer != null) {
            count++;
            pointer = pointer.next;
        }

        ListNode prev = head;
        ListNode cur = head.next;

        // iterate linked list until center and reverse iterated part
        for (int i = 1; i < count / 2; i++) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        // set pointer #1 to head of left reversed part
        ListNode pointer1 = prev;
        // set pointer #2 to head of right part
        // if linked list has odd number of nodes then skip center node
        ListNode pointer2 = count % 2 == 0 ? cur : cur.next;

        // compare left and right parts by one node at a time
        for (int i = 0; i < count / 2; i++) {
            // return false, if one of nodes do not match
            if (pointer1.val != pointer2.val)
                return false;

            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        // return true if all elements are matched
        return true;
    }

    public class ListNode {
        final int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
