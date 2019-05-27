package structures;

/**
 * Implementation of Doubly linked list
 * https://en.wikipedia.org/wiki/Doubly_linked_list
 */
public class DoublyLinkedList<DataType> {

    private Node<DataType> firstNode;
    private Node<DataType> lastNode;

    public Node<DataType> getFirstNode() {
        return firstNode;
    }

    public Node<DataType> getLastNode() {
        return lastNode;
    }

    /**
     * Adds node to the end of the linked list
     * Time complexity: O(1)
     */
    public void addAsLastNode(Node<DataType> node) {
        // no nodes
        if (lastNode == null) {
            firstNode = lastNode = node;
            node.prev = null;
            node.next = null;
            return;
        }

        // at least one node exists
        node.prev = lastNode;
        node.next = null;
        lastNode.next = node;
        lastNode = node;
    }

    /**
     * Removes node from the linked list
     * Time complexity: O(1)
     */
    public void removeNode(Node<DataType> node) {
        // node is the only one in the linked list
        if (node.prev == null && node.next == null) {
            firstNode = lastNode = null;
            return;
        }

        // node is the first
        if (node.prev == null) {
            node.next.prev = null;
            firstNode = node.next;
            node.next = null;
            return;
        }

        // node is the last
        if (node.next == null) {
            node.prev.next = null;
            lastNode = node.prev;
            node.prev = null;
            return;
        }

        // node in the middle of the linked list
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.next = null;
        node.prev = null;
    }

    public class Node<DataType> {

        private Node<DataType> prev;
        private Node<DataType> next;
        private DataType data;

        public Node(DataType data) {
            this.data = data;
        }

        public Node<DataType> getPrev() {
            return prev;
        }

        public Node<DataType> getNext() {
            return next;
        }

        public DataType getData() {
            return data;
        }
    }
}
