package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class TicTacToeTests {

    @Test public void testExample() {

        TicTacToe solution = new TicTacToe(3);
        assertEquals(0, solution.move(0,0,1));
        assertEquals(0, solution.move(0,2,2));
        assertEquals(0, solution.move(2,2,1));
        assertEquals(0, solution.move(1,1,2));
        assertEquals(0, solution.move(2,0,1));
        assertEquals(0, solution.move(1,0,2));
        assertEquals(1, solution.move(2,1,1));
    }
}
