package solutions;

import structures.BinaryMaxHeap;
import java.util.PriorityQueue;

/**
 * Solution for https://leetcode.com/problems/k-closest-points-to-origin problem with
 * Time complexity: O(n * log n) in the worst case, but O(n + (n - k) * log k) in average case
 * Space complexity: O(n)
 */
public class KClosestPointsToOrigin {

    /**
     * Calculates K closest points with usage of java.util.PriorityQueue<E>
     */
    public int[][] kClosest(int[][] points, int K) {
        // number of points to return is greater than number of all points
        if (points.length <= K) return points;

        // create max heap of size K
        // The head of PriorityQueue is the least element, but we need the most, so exchange distances in comparator
        final PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] * b[0] + b[1] * b[1] - (a[0] * a[0] + a[1] * a[1]));

        for (int[] point: points) {
            maxHeap.add(point);

            // max heap is full
            if (maxHeap.size() > K)
                maxHeap.remove();
        }

        // all K points with min distances are in the max heap
        Object[] allValues = maxHeap.toArray();

        final int[][] results = new int[K][];
        for (int i = 0; i < allValues.length; i++) {
            results[i] = (int[]) allValues[i];
        }

        return results;
    }

    class Data implements Comparable<Data> {

        private final int[] point;
        private final Integer distance;

        public Data(int[] point, Integer distance) {
            this.point = point;
            this.distance = distance;
        }

        public int[] getPoint() {
            return point;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Data data) {
            return distance.compareTo(data.distance);
        }
    }

    /**
     * Calculates K closest points with usage of custom binary max heap
     */
    public int[][] kClosest2(int[][] points, int K) {
        // number of points to return is greater than number of all points
        if (points.length <= K) return points;

        // create max heap of size K
        final BinaryMaxHeap<Data> maxHeap = new BinaryMaxHeap<>(K);

        for (int[] point: points) {
            // calculate distance
            final Integer distance = point[0] * point[0] + point[1] * point[1];

            // max heap is full
            if (maxHeap.getSize() >= K) {
                final Data maxValue = maxHeap.getMaxValue();

                // max distance in max heap is less or equal to the distance for current point
                if (maxValue.distance <= distance) {
                    // skip current point
                    continue;
                }

                // remove max distance from max heap
                maxHeap.removeMaxValue();
            }

            // add current point
            final Data data = new Data(point, distance);
            maxHeap.add(data);
        }

        // all K points with min distances are in the max heap
        Object[] allValues = maxHeap.getAllValues();

        int[][] results = new int[allValues.length][];
        for (int i = 0; i < allValues.length; i++) {
            final Data data = (Data) allValues[i];
            results[i] = data.getPoint();
        }

        return results;
    }
}
