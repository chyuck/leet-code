package solutions;

import java.util.*;

/**
 * Solution for https://leetcode.com/problems/shortest-bridge/ problem with
 * Time complexity: O(A)
 * Space complexity: O(A)
 * where A - total number of elements in input array
 */
public class ShortestBridge {

    private static final int ORIGINAL_ISLAND_ID = 1;
    private static final int SOURCE_ISLAND_ID = 2;
    private static final int TARGET_ISLAND_ID = ORIGINAL_ISLAND_ID;

    private static final int[] H_DELTAS = new int[] { -1, 0, 1, 0 };
    private static final int[] V_DELTAS = new int[] { 0, -1, 0, 1 };

    public int shortestBridge(int[][] A) {
        Queue<Node> sourceIslandNodes = new LinkedList<>();

        separateSourceIsland(A, sourceIslandNodes);

        return findShortestPathBetweenIslands(A, sourceIslandNodes);
    }

    private static void separateSourceIsland(int[][] A, Queue<Node> results) {
        int N = A.length;

        for (int r = 0; r < N ; r++) {
            for (int c = 0; c < N; c++) {
                if (A[r][c] == ORIGINAL_ISLAND_ID) {
                    dfs(A, r, c, results);
                    return;
                }
            }
        }
    }

    private static void dfs(int[][] A, int r, int c, Queue<Node> results) {
        if (!isValid(A, r, c) || A[r][c] != ORIGINAL_ISLAND_ID) {
            return;
        }

        A[r][c] = SOURCE_ISLAND_ID;
        results.offer(new Node(r, c, 0));

        dfs(A, r, c - 1, results);
        dfs(A, r - 1, c, results);
        dfs(A, r, c + 1, results);
        dfs(A, r + 1, c, results);
    }

    private static boolean isValid(int[][] A, int r, int c) {
        int N = A.length;

        return 0 <= r && r < N && 0 <= c && c < N;
    }

    private static int findShortestPathBetweenIslands(int[][] A, Queue<Node> bfs) {
        int N = A.length;

        while (!bfs.isEmpty()) {
            Node node = bfs.poll();

            for (int i = 0; i < 4; i++) {
                int r = node.row + V_DELTAS[i];
                int c = node.col + H_DELTAS[i];

                if (!isValid(A, r, c)) {
                    continue;
                }

                int id = A[r][c];

                if (id == TARGET_ISLAND_ID) {
                    return node.depth;
                }

                if (id == SOURCE_ISLAND_ID) {
                    continue;
                }

                A[r][c] = SOURCE_ISLAND_ID;

                bfs.offer(new Node(r, c, node.depth + 1));
            }
        }

        throw new RuntimeException();
    }

    private static class Node {
        final int row;
        final int col;
        final int depth;

        Node(int row, int col, int depth) {
            this.row = row;
            this.col = col;
            this.depth = depth;
        }
    }
}
