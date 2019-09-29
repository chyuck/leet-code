package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

    public void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0].length <= 2) return;

        int R = board.length, C = board[0].length;

        boolean[][] visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] == 'X') continue;
                if (visited[r][c]) continue;

                capture(board, visited, r, c);
            }
        }
    }

    private void capture(char[][] board, boolean[][] visited, int row, int col)     {

        int R = board.length, C = board[0].length;

        ArrayList<int[]> cellsToCapture = new ArrayList<>();

        Queue<int[]> bfs = new LinkedList<int[]>();
        bfs.add(new int[] { row, col });

        boolean capture = true;

        while (bfs.size() > 0) {
            int[] cell = bfs.remove();
            int r = cell[0], c = cell[1];

            if (board[r][c] == 'X') continue;
            if (visited[r][c]) continue;

            visited[r][c] = true;
            cellsToCapture.add(cell);

            if (c - 1 >= 0) bfs.add(new int[] { r, c-1 });
            if (r - 1 >= 0) bfs.add(new int[] { r-1, c });
            if (c + 1 < C) bfs.add(new int[] { r, c+1 });
            if (r + 1 < R) bfs.add(new int[] { r+1, c });

            if (r == 0 || r == R-1 || c==0 || c == C-1)
                capture = false;
        }

        if (!capture) return;

        for (int[] cell : cellsToCapture) {
            board[cell[0]][cell[1]] = 'X';
        }
    }
}
