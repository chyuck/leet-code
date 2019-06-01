package structures;

/**
 * Implementation of Stack using singly linked list
 * https://en.wikipedia.org/wiki/Stack_(abstract_data_type)
 */
public class Stack<DataType> {

    private Node<DataType> firstNode;

    /**
     * Adds element to stack and returns it
     * Time complexity: O(1)
     */
    public DataType push(DataType data) {
        final Node<DataType> node = new Node<>(data);

        // elements exist
        if (firstNode != null) {
            node.next = firstNode;
        }

        firstNode = node;

        return data;
    }

    /**
     * Returns the element and removes it
     * Time complexity: O(1)
     */
    public DataType pop() {
        // no elements
        if (firstNode == null)
            throw new IllegalStateException("No elements.");

        // elements exist
        final DataType result = firstNode.data;

        firstNode = firstNode.next;

        return result;
    }

    /**
     * Returns the element without removing it
     * Time complexity: O(1)
     */
    public DataType peak() {
        // no elements
        if (firstNode == null)
            throw new IllegalStateException("No elements.");

        return firstNode.data;
    }

    /**
     * Checks whether stack is empty
     * Time complexity: O(1)
     */
    public boolean isEmpty() {
        return firstNode == null;
    }

    class Node<DataType> {

        private Node<DataType> next;
        private DataType data;

        public Node(DataType data) {
            this.data = data;
        }
    }
}
