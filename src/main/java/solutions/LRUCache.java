package solutions;

import java.util.HashMap;

/**
 * Solution for https://leetcode.com/problems/lru-cache problem
 * Space complexity: O(n)
 */
public class LRUCache {

    private class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;
    }

    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    private Node head, tail;
    private final HashMap<Integer, Node> keysToNodes = new HashMap<>();

    private void removeNode(Node node) {
        // only one node
        if (node.prev == null && node.next == null) {
            head = tail = null;
            return;
        }

        // first node
        if (node.prev == null) {
            Node next = node.next;
            next.prev = null;
            head = next;

            node.next = null;

            return;
        }

        // last node
        if (node.next == null) {
            Node prev = node.prev;
            prev.next = null;
            tail = prev;

            node.prev = null;

            return;
        }

        // in the middle
        {
            Node prev = node.prev;
            Node next = node.next;

            prev.next = next;
            next.prev = prev;

            node.prev = node.next = null;
        }
    }

    private void addNodeToTail(Node node) {
        // empty linked list
        if (tail == null) {
            head = tail = node;

            return;
        }

        // linked list has nodes
        Node prev = tail;
        prev.next = node;

        node.prev = prev;
        tail = node;
    }

    private void moveNodeToTail(Node node) {
        // already at tail
        if (node.next == null) return;

        removeNode(node);
        addNodeToTail(node);
    }

    /**
     * Returns value by key with
     * Time complexity: O(1)
     */
    public int get(int key) {
        Node node = keysToNodes.get(key);

        // key does not exist
        if (node == null) return -1;

        // key exist
        moveNodeToTail(node);

        return node.value;
    }

    /**
     * Inserts or updates value with key with
     * Time complexity: O(1)
     */
    public void put(int key, int value) {
        Node node = keysToNodes.get(key);

        // key exists
        if (node != null) {
            moveNodeToTail(node);
            node.value = value;

            return;
        }

        // key does not exist

        // capacity is full, remove first node
        if (keysToNodes.size() == capacity) {
            Node first = head;
            removeNode(first);
            keysToNodes.remove(first.key);
        }

        // add new
        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;

        addNodeToTail(newNode);
        keysToNodes.put(newNode.key, newNode);
    }
}
