package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class PartitionLabelsTests {

    @Test public void testExample() {
        // arrange
        var solution = new PartitionLabels();

        // act
        var result = solution.partitionLabels("ababcbacadefegdehijhklij");

        // assert
        assertArrayEquals(new Integer[] { 9,7,8 }, result.toArray(new Integer[] {}));
    }
}
