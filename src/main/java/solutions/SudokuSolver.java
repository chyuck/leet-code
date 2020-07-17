package solutions;

/**
 * Solution for https://leetcode.com/problems/sudoku-solver/ problem with
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
public class SudokuSolver {

    private static class Constraints {
        final boolean[][] rows = new boolean[9][10];
        final boolean[][] cols = new boolean[9][10];
        final boolean[][] boxes = new boolean[9][10];
    }

    public void solveSudoku(char[][] board) {
        Constraints constraints = initializeConstraints(board);

        backtrack(0, 0, constraints, board);
    }

    private static Constraints initializeConstraints(char[][] board) {
        Constraints result = new Constraints();

        for (int row = 0; row <= 8; row++) {
            for (int col = 0; col <= 8; col++) {
                char ch = board[row][col];

                if (ch != '.') {
                    int num = ch - '0';
                    addToBoard(num, row, col, result, board);
                }
            }
        }

        return result;
    }

    private static boolean backtrack(int row, int col, Constraints constraints, char[][] board) {
        if (row == 9 && col == 0) {
            return true;
        }

        if (board[row][col] != '.') {
            return backtrack(getNextRow(row, col), getNextColumn(col), constraints, board);
        }

        for (int num = 1; num <= 9; num++) {
            if (!canAddToBoard(num, row, col, constraints)) {
                continue;
            }

            addToBoard(num, row, col, constraints, board);

            if (backtrack(getNextRow(row, col), getNextColumn(col), constraints, board)) {
                return true;
            }

            removeFromBoard(num, row, col, constraints, board);
        }

        return false;
    }

    private static int getNextRow(int row, int col) {
        return col < 8 ? row: row + 1;
    }

    private static int getNextColumn(int col) {
        return col < 8 ? col + 1 : 0;
    }

    private static int getBoxIndex(int row, int col) {
        return (row / 3) * 3  + (col / 3);
    }

    private static boolean canAddToBoard(int num, int row, int col, Constraints constraints) {
        int box = getBoxIndex(row, col);

        return !constraints.rows[row][num] && !constraints.cols[col][num] && !constraints.boxes[box][num];
    }

    private static void addToBoard(int num, int row, int col, Constraints constraints, char[][] board) {
        int box = getBoxIndex(row, col);

        constraints.rows[row][num] = true;
        constraints.cols[col][num] = true;
        constraints.boxes[box][num] = true;

        board[row][col] = (char) ('0' + num);
    }

    private static void removeFromBoard(int num, int row, int col, Constraints constraints, char[][] board) {
        int box = getBoxIndex(row, col);

        constraints.rows[row][num] = false;
        constraints.cols[col][num] = false;
        constraints.boxes[box][num] = false;

        board[row][col] = '.';
    }
}
