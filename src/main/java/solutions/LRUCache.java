package solutions;

import structures.DoublyLinkedList;

import java.util.HashMap;

/**
 * Solution for https://leetcode.com/problems/lru-cache problem
 */
public class LRUCache {

    class Data {
        private int key;
        private int value;

        public Data(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<Integer, DoublyLinkedList<Data>.Node<Data>> keysToNodes = new HashMap<>();
    private final DoublyLinkedList<Data> nodes = new DoublyLinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Returns value by key with
     * Time complexity: O(1)
     * Space complexity: O(n)
     */
    public int get(int key) {
        // key does not exist
        if (!keysToNodes.containsKey(key))
            return -1;

        // key exist
        final DoublyLinkedList<Data>.Node<Data> node = keysToNodes.get(key);
        // move node to the end of linked list
        nodes.removeNode(node);
        nodes.addAsLastNode(node);

        return node.getData().getValue();
    }

    /**
     * Inserts or updates value with key with
     * Time complexity: O(1)
     * Space complexity: O(n)
     */
    public void put(int key, int value) {
        // key exists
        if (keysToNodes.containsKey(key)) {
            final DoublyLinkedList<Data>.Node<Data> node = keysToNodes.get(key);
            // move node to the end of linked list
            nodes.removeNode(node);
            nodes.addAsLastNode(node);
            // update value
            node.getData().setValue(value);
            return;
        }

        // key does not exist
        // capacity is full
        if (keysToNodes.size() == capacity) {
            // remove first node
            final DoublyLinkedList<Data>.Node<Data> firstNode = nodes.getFirstNode();
            nodes.removeNode(firstNode);
            keysToNodes.remove(firstNode.getData().getKey());
        }

        // add new node to the end
        final Data data = new Data(key, value);
        final DoublyLinkedList<Data>.Node<Data> newNode = nodes.new Node<Data>(data);
        nodes.addAsLastNode(newNode);
        keysToNodes.put(key, newNode);
    }
}
