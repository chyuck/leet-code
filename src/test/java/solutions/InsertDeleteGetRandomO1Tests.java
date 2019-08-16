package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class InsertDeleteGetRandomO1Tests {

    @Test public void testExample(){
        // Init an empty set.
        InsertDeleteGetRandomO1 randomSet = new InsertDeleteGetRandomO1();

        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        assertTrue(randomSet.insert(1));

        // Returns false as 2 does not exist in the set.
        assertFalse(randomSet.remove(2));

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        assertTrue(randomSet.insert(2));

        // getRandom should return either 1 or 2 randomly.
        int result = randomSet.getRandom();
        assertTrue(result == 1 || result == 2);

        // Removes 1 from the set, returns true. Set now contains [2].
        assertTrue(randomSet.remove(1));

        // 2 was already in the set, so return false.
        assertFalse(randomSet.insert(2));

        // Since 2 is the only number in the set, getRandom always return 2.
        assertEquals(2, randomSet.getRandom());
    }
}
