package solutions;

/**
 * Solution for https://leetcode.com/problems/intersection-of-two-linked-lists/ problem with
 * Time complexity: O(A + B)
 * Space complexity: O(1)
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        // record last node
        ListNode lastNode = null;
        // start traversing from heads
        ListNode p1 = headA, p2 = headB;

        // the idea is to traverse A and B from heads and when any pointer reaches the end, switch it to another head
        // after switching both pointers to other heads, pointers must meet at intersection,
        // because pointer #1 will traverse A + B number of nodes, and pointer #2 will traverse B + A number of nodes
        // as long as last nodes are the same, then A and B meet at first shared node, which is result
        while (true) {
            // if pointer #1 meets pointer #2
            if (p1 == p2)
                return p1;

            // reached the end
            if (p1.next == null) {
                // if end is different, then means there is no intersection
                if (lastNode != null && lastNode != p1)
                    return null;
                // record last node
                lastNode = p1;
                // switch to another head
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            // the same for another pointer
            if (p2.next == null) {
                if (lastNode != null && lastNode != p2)
                    return null;
                lastNode = p2;
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
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
