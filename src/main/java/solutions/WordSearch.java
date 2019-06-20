package solutions;

/**
 * Solution for https://leetcode.com/problems/word-search/ problem with
 * Time complexity: O(N * M * W)
 * Space complexity: O(1)
 * where N, M - board dimensions, W - length of word
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;
        if (word == null || word.isEmpty()) return false;

        // loop through each cell on board until word is found
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (search(board, word, 0, row, col))
                    return true;
            }
        }

        // word is not found
        return false;
    }

    private boolean search(char[][] board, String word, int index, int row, int col) {
        // word is found
        if (word.length() <= index) return true;

        // out of board
        if (row < 0 || row >= board.length) return false;
        if (col < 0 || col >= board[0].length) return false;

        // letter does not match
        if (word.charAt(index) != board[row][col]) return false;

        // clear visited cell to skip in future
        board[row][col] = '*';

        // move to left, then top, then right, then bottom cells
        boolean found = search(board, word, index + 1, row, col - 1)
                || search(board, word, index + 1, row - 1, col)
                || search(board, word, index + 1, row, col + 1)
                || search(board, word, index + 1, row + 1, col);

        if (found) return true;

        // not found, rollback to original character
        board[row][col] = word.charAt(index);

        return false;
    }
}
