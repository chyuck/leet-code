package structures;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryMaxHeapTests {

    @Test public void testAdd() {
        final var heap = new BinaryMaxHeap<Integer>(5);

        assertEquals(0, heap.getSize());

        heap.add(2);
        assertEquals((Integer) 2, heap.getMaxValue());
        assertEquals(1, heap.getSize());

        heap.add(1);
        assertEquals((Integer) 2, heap.getMaxValue());
        assertEquals(2, heap.getSize());

        heap.add(3);
        assertEquals((Integer) 3, heap.getMaxValue());
        assertEquals(3, heap.getSize());

        heap.add(2);
        assertEquals((Integer) 3, heap.getMaxValue());
        assertEquals(4, heap.getSize());

        heap.add(4);
        assertEquals((Integer) 4, heap.getMaxValue());
        assertEquals(5, heap.getSize());
    }

    @Test public void testRemoveMaxValue() {
        final var heap = new BinaryMaxHeap<Integer>(3);

        heap.add(1);
        heap.add(2);
        heap.add(3);

        assertEquals(3, heap.getSize());

        assertEquals((Integer) 3, heap.removeMaxValue());
        assertEquals((Integer) 2, heap.getMaxValue());
        assertEquals(2, heap.getSize());

        assertEquals((Integer) 2, heap.removeMaxValue());
        assertEquals((Integer) 1, heap.getMaxValue());
        assertEquals(1, heap.getSize());

        assertEquals((Integer) 1, heap.removeMaxValue());
        assertEquals(0, heap.getSize());
    }

    @Test public void testGetAllValues() {
        final var heap = new BinaryMaxHeap<Integer>(3);

        heap.add(1);
        heap.add(2);
        heap.add(3);

        assertArrayEquals(new Object[] { 3, 1, 2 }, heap.getAllValues());
    }
}
