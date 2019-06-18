package solutions;

/**
 * Solution for https://leetcode.com/problems/merge-two-sorted-lists problem with
 * Time complexity: O(n + m)
 * Space complexity: O(1)
 * where n, m - lengths of first and second linked lists
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // result with dummy node, which will be removed before returning result
        ListNode result = new ListNode(0);
        // pointer to result
        ListNode pointer = result;

        // loop until end of one of linked lists
        while (l1 != null && l2 != null) {
            // first list value has value less or equal than second list value
            // add first list node to result, and move first list pointer to the next one
            if (l1.val <= l2.val) {
                pointer.next = l1;
                pointer = pointer.next;

                l1 = l1.next;
                continue;
            }

            // first list value has value greater than second list value
            // add second list node to result, and move second list pointer to the next one
            pointer.next = l2;
            pointer = pointer.next;
            l2 = l2.next;
        }

        // add leftovers from first list to result
        if (l1 != null) {
            pointer.next = l1;
            return result.next;
        }

        // add leftovers from second list to result
        if (l2 != null) {
            pointer.next = l2;
        }

        // return result without dummy value
        return result.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
