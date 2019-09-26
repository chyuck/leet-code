package solutions;

/**
 * Solution for https://leetcode.com/problems/design-tic-tac-toe problem with
 * Time complexity: O(1)
 * Space complexity: O(n)
 */
public class TicTacToe {
    // IDEA: keep counters for each row, each column and two diagonals
    // For player #1 increment counter, for player #2 decrement counter
    // if absolute value of one of counters reaches the length of board,
    // it means that full row, column or diagonal is filled by one player

    private final int n;
    private final int[] rowCounter;
    private final int[] colCounter;
    private int leftToRightDiagCounter = 0;
    private int rightToLeftDiagCounter = 0;

    public TicTacToe(int n) {
        this.n = n;
        rowCounter = new int[n];
        colCounter = new int[n];
    }

    public int move(int row, int col, int player) {
        int value = player == 1 ? 1 : -1;

        rowCounter[row] += value;
        colCounter[col] += value;
        if (row == col) leftToRightDiagCounter += value;
        if (row + col + 1 == n) rightToLeftDiagCounter += value;

        if (Math.abs(rowCounter[row]) == n
                || Math.abs(colCounter[col]) == n
                || Math.abs(leftToRightDiagCounter) == n
                || Math.abs(rightToLeftDiagCounter) == n )
            return player;

        return 0;
    }
}
