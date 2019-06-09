package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class AddTwoNumbersTests {

    @Test public void testExample() {
        // arrange
        final var solution = new AddTwoNumbers();

        final var number1 =
            solution.new ListNode(2,
                solution.new ListNode(4,
                    solution.new ListNode(3)));

        final var number2 =
            solution.new ListNode(5,
                solution.new ListNode(6,
                    solution.new ListNode(4)));

        // act
        final var result = solution.addTwoNumbers(number1, number2);

        // assert
        assertNotNull(result);
        assertEquals(7, result.val);
        assertNotNull(result.next);
        assertEquals(0, result.next.val);
        assertNotNull(result.next.next);
        assertEquals(8, result.next.next.val);
    }
}
