package solutions;

/**
 * Solution for https://leetcode.com/problems/intersection-of-two-linked-lists/ problem with
 * Time complexity: O(A + B)
 * Space complexity: O(1)
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;

        boolean switched1 = false;
        boolean switched2 = false;

        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }

            p1 = p1.next;
            if (p1 == null && !switched1) {
                p1 = headB;
                switched1 = true;
            }

            p2 = p2.next;
            if (p2 == null && !switched2) {
                p2 = headA;
                switched2 = true;
            }
        }

        return null;
    }

    public class ListNode {
        final int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    }
}
