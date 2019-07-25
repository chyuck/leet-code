package solutions;

/**
 * Solution for https://leetcode.com/problems/linked-list-cycle problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        // create slow pointer which will go one step at a time
        // head will be fast pointer will go two steps at a time
        ListNode pointer = head;

        while (true) {

            // do two steps for fast pointer
            for (int i = 0; i < 2; i++) {
                head = head.next;

                // if reached the end, then return no cycle
                if (head == null)
                    return false;

                // if fast met slow pointer, then return that cycle exist
                if (pointer == head)
                    return true;
            }

            // do one step for slow pointer
            pointer = pointer.next;
        }
    }

    public class ListNode {
        final int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
