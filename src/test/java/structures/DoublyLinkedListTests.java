package structures;

import org.junit.Test;
import static org.junit.Assert.*;

public class DoublyLinkedListTests {

    @Test public void testAddAsLastNodeWhenLinkedListIsEmpty() {
        // arrange
        final var linkedList = new DoublyLinkedList<Integer>();

        final var node = linkedList.new Node<>(1);

        // act
        linkedList.addAsLastNode(node);

        // assert
        assertEquals(linkedList.getFirstNode(), node);
        assertEquals(linkedList.getLastNode(), node);

        assertNull(node.getPrev());
        assertNull(node.getNext());
    }

    @Test public void testAddAsLastNodeWhenLinkedListIsNotEmpty() {
        // arrange
        final var linkedList = new DoublyLinkedList<Integer>();

        final var node1 = linkedList.new Node<>(1);
        linkedList.addAsLastNode(node1);

        final var node2 = linkedList.new Node<>(2);

        // act
        linkedList.addAsLastNode(node2);

        // assert
        assertEquals(linkedList.getFirstNode(), node1);
        assertEquals(linkedList.getLastNode(), node2);

        assertEquals(node1.getNext(), node2);
        assertNull(node1.getPrev());

        assertEquals(node2.getPrev(), node1);
        assertNull(node2.getNext());
    }

    @Test public void testRemoveNodeWhenLinkedListHasOnlyOneNode() {
        // arrange
        final var linkedList = new DoublyLinkedList<Integer>();

        final var node = linkedList.new Node<>(1);
        linkedList.addAsLastNode(node);

        // act
        linkedList.removeNode(node);

        // assert
        assertNull(linkedList.getFirstNode());
        assertNull(linkedList.getLastNode());

        assertNull(node.getPrev());
        assertNull(node.getNext());
    }

    @Test public void testRemoveNodeWhenNodeIsFirst() {
        // arrange
        final var linkedList = new DoublyLinkedList<Integer>();

        final var node1 = linkedList.new Node<>(1);
        linkedList.addAsLastNode(node1);

        final var node2 = linkedList.new Node<>(2);
        linkedList.addAsLastNode(node2);

        // act
        linkedList.removeNode(node1);

        // assert
        assertEquals(linkedList.getFirstNode(), node2);
        assertEquals(linkedList.getLastNode(), node2);

        assertNull(node1.getNext());
        assertNull(node1.getPrev());

        assertNull(node2.getPrev());
        assertNull(node2.getNext());
    }

    @Test public void testRemoveNodeWhenNodeIsLast() {
        // arrange
        final var linkedList = new DoublyLinkedList<Integer>();

        final var node1 = linkedList.new Node<>(1);
        linkedList.addAsLastNode(node1);

        final var node2 = linkedList.new Node<>(2);
        linkedList.addAsLastNode(node2);

        // act
        linkedList.removeNode(node2);

        // assert
        assertEquals(linkedList.getFirstNode(), node1);
        assertEquals(linkedList.getLastNode(), node1);

        assertNull(node1.getNext());
        assertNull(node1.getPrev());

        assertNull(node2.getPrev());
        assertNull(node2.getNext());
    }

    @Test public void testRemoveNodeWhenNodeIsInTheMiddle() {
        // arrange
        final var linkedList = new DoublyLinkedList<Integer>();

        final var node1 = linkedList.new Node<>(1);
        linkedList.addAsLastNode(node1);

        final var node2 = linkedList.new Node<>(2);
        linkedList.addAsLastNode(node2);

        final var node3 = linkedList.new Node<>(3);
        linkedList.addAsLastNode(node3);

        // act
        linkedList.removeNode(node2);

        // assert
        assertEquals(linkedList.getFirstNode(), node1);
        assertEquals(linkedList.getLastNode(), node3);

        assertEquals(node1.getNext(), node3);
        assertEquals(node3.getPrev(), node1);

        assertNull(node2.getPrev());
        assertNull(node2.getNext());
    }
}
