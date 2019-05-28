package structures;

import java.util.Arrays;

/**
 * Implementation of Binary max heap
 * https://en.wikipedia.org/wiki/Binary_heap
 */
public class BinaryMaxHeap<ValueType extends Comparable> {

    private final int maxSize;
    private final Object[] data;
    private int size = 0;

    public BinaryMaxHeap(int maxSize) {
        this.maxSize = maxSize;
        data = new Object[maxSize];
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getSize() {
        return size;
    }

    /**
     * Adds value to the heap
     * Time complexity: O(log n) in the worst case, but O(1) in average case
     */
    public void add(ValueType value) {
        if (size == maxSize) throw new IllegalStateException("Size has reached its limit.");

        // add value to the end
        final int index = size;
        data[index] = value;
        size++;

        // bubble up to comply with heap properties
        bubbleUp(index);
    }

    /**
     * Removes max value from the heap
     * Time complexity: O(log n)
     */
    public ValueType removeMaxValue() {
        if (size == 0) throw new IllegalStateException("Heap is empty.");

        final ValueType maxValue = (ValueType) data[0];

        // heap has only one element
        if (size == 1) {
            size--;
            return maxValue;
        }

        // move the last element to the top
        data[0] = data[size - 1];
        size--;

        // bubble down to comply with heap properties
        bubbleDown(0);

        return maxValue;
    }

    /**
     * Returns max value
     * Time complexity: O(1)
     */
    public ValueType getMaxValue() {
        if (size == 0) throw new IllegalStateException("Heap is empty.");

        return (ValueType) data[0];
    }

    /**
     * Returns all values
     * Time complexity: O(n)
     */
    public Object[] getAllValues() {
        return Arrays.copyOf(data, size);
    }

    private void bubbleUp(int index) {
        // already top element
        if (index <= 0) return;

        final ValueType value =  (ValueType) data[index];

        final int parentIndex = getParentIndex(index);
        final ValueType parentValue = (ValueType) data[parentIndex];

        // parent already is greater or equal to child
        if (parentValue.compareTo(value) >= 0) return;

        // swap parent and child elements
        swap(parentIndex, index);

        // continue bubbling up
        bubbleUp(parentIndex);
    }

    private void bubbleDown(int index) {
        // already last element
        if (index >= size - 1) return;

        final ValueType value =  (ValueType) data[index];

        final int leftChildIndex = getLeftChildIndex(index);
        // no children
        if (leftChildIndex > size - 1) return;
        final ValueType leftChildValue = (ValueType) data[leftChildIndex];

        final int rightChildIndex = getRightChildIndex(index);
        // no right child
        if (rightChildIndex > size - 1) {
            // parent already is greater or equal to child
            if (value.compareTo(leftChildValue) >= 0) return;

            // swap parent and left child elements
            swap(index, leftChildIndex);

            // continue bubbling down
            bubbleDown(leftChildIndex);

            return;
        }

        final ValueType rightChildValue = (ValueType) data[rightChildIndex];

        // parent already is greater or equal to children
        if (value.compareTo(leftChildValue) >= 0 && value.compareTo(rightChildValue) >= 0) return;

        // left child is greater
        if (leftChildValue.compareTo(rightChildValue) >= 0) {
            // swap parent and left child elements
            swap(index, leftChildIndex);

            // continue bubbling down
            bubbleDown(leftChildIndex);

            return;
        }

        // swap parent and right child elements
        swap(index, rightChildIndex);

        // continue bubbling down
        bubbleDown(rightChildIndex);
    }

    private void swap(int index1, int index2) {
        final Object value1 =  data[index1];
        data[index1] = data[index2];
        data[index2] = value1;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }
}
