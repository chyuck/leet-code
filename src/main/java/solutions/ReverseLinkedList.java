package solutions;

/**
 * Solution for https://leetcode.com/problems/reverse-linked-list problem with
 * Time complexity: O(N)
 * Space complexity: O(N)
 * where N - number of nodes in the linked list
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        // pointer to result list's head
        ListNode pointer = null;

        // loop through input list
        while (head != null) {
            // create new node for result list
            ListNode node = new ListNode(head.val);
            // append new node to the head of result list
            node.next = pointer;
            // point pointer to result list's head
            pointer = node;

            // move to the next inout node
            head = head.next;
        }

        // return head of result list
        return pointer;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        // create dummy head for result list
        ListNode result = new ListNode(0);

        // build reversed list
        backtrack(head, result);

        // return result list without dummy head
        return result.next;
    }

    private ListNode backtrack(ListNode node, ListNode result) {
        // if last node
        if (node.next == null) {
            // append last node to result
            result.next = new ListNode(node.val);
            // return last node
            return result.next;
        }

        // build result list for next input nodes
        ListNode prevNodes = backtrack(node.next, result);
        // append current node to result list
        prevNodes.next = new ListNode(node.val);

        // return last node
        return prevNodes.next;
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
