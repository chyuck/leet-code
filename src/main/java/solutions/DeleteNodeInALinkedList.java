package solutions;

/**
 * Solution for https://leetcode.com/problems/delete-node-in-a-linked-list/ problem with
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;

        node.val = nextNode.val;
        node.next = nextNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this(val, null);
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
