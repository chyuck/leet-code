package solutions;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solution for https://leetcode.com/problems/k-closest-points-to-origin problem with
 * Time complexity: O(n * log k)
 * Space complexity: O(k)
 */
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        Queue<int[]> heap = createAndPopulateMaxHeap(points, K);

        return heap.toArray(new int[heap.size()][2]);
    }

    private static Queue<int[]> createAndPopulateMaxHeap(int[][] points, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b)-> {
            int distanceA = a[0] * a[0] + a[1] * a[1];
            int distanceB = b[0] * b[0] + b[1] * b[1];

            return distanceB - distanceA;
        });

        for (int[] point : points) {
            maxHeap.add(point);

            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }

        return maxHeap;
    }
}
