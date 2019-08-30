package solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution for https://leetcode.com/problems/flood-fill problem with
 * Time complexity: O(N * M)
 * Space complexity: O(N * M)
 * where N, M - dimensions of image
 */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        // don't do anything if we don't need to change color
        if (oldColor == newColor)
            return image;

        // flood all pixels using bfs, iterative approach
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sr, sc});

        while (!queue.isEmpty()) {
            int[] pixel = queue.remove();
            int row = pixel[0], col = pixel[1];
            image[row][col] = newColor;

            addNeighborPixelsToQueueAndFlood(image, row, col, oldColor, queue);
        }

        return image;
    }

    private void addNeighborPixelsToQueueAndFlood(int[][] image, int row, int col, int oldColor, Queue<int[]> queue) {
        addPixelToQueueAndFlood(image, row, col - 1, oldColor, queue);
        addPixelToQueueAndFlood(image, row - 1, col, oldColor, queue);
        addPixelToQueueAndFlood(image, row, col + 1, oldColor, queue);
        addPixelToQueueAndFlood(image, row + 1, col, oldColor, queue);
    }

    private void addPixelToQueueAndFlood(int[][] image, int row, int col, int oldColor, Queue<int[]> queue) {
        if (!isValid(image, row, col))
            return;

        if (image[row][col] != oldColor)
            return;

        queue.add(new int[] {row, col});
    }

    private boolean isValid(int[][] image, int row, int col) {
       if (row < 0 || row >= image.length)
           return false;
        if (col < 0 || col >= image[0].length)
            return false;

        return true;
    }
}
