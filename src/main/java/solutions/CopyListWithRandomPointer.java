package solutions;

import java.util.HashMap;

/**
 * Solutions for https://leetcode.com/problems/copy-list-with-random-pointer problem with
 * Time complexity: O(n)
 */
public class CopyListWithRandomPointer {

    public class Node {
        public int val;
        public Node next;
        public Node random;
    }

    /**
     * Space complexity: O(1)
     */
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // create new nodes, make old node to have corresponding new node as next,
        // and new node to have corresponding next old node as next
        Node pointer = head;
        while (pointer != null) {
            final Node node = new Node();
            node.val = pointer.val;
            // next of new node is next of old node
            node.next = pointer.next;

            // next of old node is new node
            pointer.next = node;

            pointer = node.next;
        }

        // save head of new nodes
        final Node newHead = head.next;

        // update random references in new nodes
        pointer = head;
        while (pointer != null) {
            final Node node = pointer.next;
            // update random reference in new node
            node.random = pointer.random != null ? pointer.random.next : null;

            pointer = node.next;
        }

        // update next references in new nodes
        // and fix next references in old nodes
        pointer = head;
        // create global variable to keep O(1) space complexity
        Node next;
        while (pointer != null) {
            final Node node = pointer.next;
            next = node.next;
            // update next reference in new node
            node.next = next != null ? next.next : null;

            // fix next reference in old node
            pointer.next = next;

            pointer = next;
        }

        return newHead;
    }

    /**
     * Space complexity: O(n)
     */
    public Node copyRandomList2(Node head) {
        final HashMap<Integer, Node> valuesToNodes = new HashMap<>();

        return copyNode(valuesToNodes, head);
    }

    private Node copyNode(final HashMap<Integer, Node> valuesToNodes, final Node node) {
        // node is null
        if (node == null)
            return null;

        // node already copied
        if (valuesToNodes.containsKey(node.val))
            return valuesToNodes.get(node.val);

        // create copy
        final Node newNode = new Node();
        valuesToNodes.put(node.val, newNode);

        newNode.val = node.val;
        newNode.next = copyNode(valuesToNodes, node.next);
        newNode.random = copyNode(valuesToNodes, node.random);

        return newNode;
    }

    /**
     * Space complexity: O(n)
     */
    public Node copyRandomList3(Node head) {
        // node is null
        if (head == null)
            return null;

        final HashMap<Integer, Node> valuesToNodes = new HashMap<>();

        // populate hash map
        Node pointer = head;
        while (pointer != null) {
            final Node node = new Node();
            node.val = pointer.val;
            valuesToNodes.put(pointer.val, node);

            pointer = pointer.next;
        }

        // update next and random references
        pointer = head;
        while (pointer != null) {
            final Node node = valuesToNodes.get(pointer.val);
            node.next = pointer.next != null ? valuesToNodes.get(pointer.next.val) : null;
            node.random = pointer.random != null ? valuesToNodes.get(pointer.random.val) : null;

            pointer = pointer.next;
        }

        return valuesToNodes.get(head.val);
    }
}
