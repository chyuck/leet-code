package solutions;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class GroupAnagramsTests {

    @Test public void testExample() {
        // arrange
        var solution = new GroupAnagrams();

        // act
        var results = solution.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });

        // assert
        assertEquals(3, results.size());

        assertTrue(results.contains(List.of("eat","tea","ate")));
        assertTrue(results.contains(List.of("tan","nat")));
        assertTrue(results.contains(List.of("bat")));
    }
}
