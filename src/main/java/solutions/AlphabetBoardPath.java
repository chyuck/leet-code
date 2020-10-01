package solutions;

/**
 * Solution for https://leetcode.com/problems/alphabet-board-path/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class AlphabetBoardPath {

    public String alphabetBoardPath(String target) {
        StringBuilder result = new StringBuilder();

        int row = 0, col = 0;

        for (int i = 0; i < target.length(); i++) {
            char letter = target.charAt(i);
            char nextLetter = letter == 'z' && row < 5 ? 'u' : letter;

            int nextRow = getRowIndex(nextLetter);
            int nextCol = getColIndex(nextLetter);

            int rowMoves = Math.abs(row - nextRow);
            int colMoves = Math.abs(col - nextCol);

            char rowMoveChar = row < nextRow ? 'D' : 'U';
            char colMoveChar = col < nextCol ? 'R' : 'L';

            for (int r = 0; r < rowMoves; r++) {
                result.append(rowMoveChar);
            }

            for (int c = 0; c < colMoves; c++) {
                result.append(colMoveChar);
            }

            row = nextRow;
            col = nextCol;

            if (nextLetter == 'u' && letter == 'z') {
                result.append('D');
                row++;
            }

            result.append('!');
        }

        return result.toString();
    }

    private static int getRowIndex(char letter) {
        return (letter - 'a') / 5;
    }

    private static int getColIndex(char letter) {
        return (letter - 'a') % 5;
    }
}
