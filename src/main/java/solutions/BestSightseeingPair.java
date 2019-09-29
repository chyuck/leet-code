package solutions;

public class BestSightseeingPair {

    public int maxScoreSightseeingPair(int[] A) {

        int max = A[0] + 0;
        int result = 0;

        for (int i = 1; i < A.length; i++) {
            result = Math.max(result, max + A[i] - i);
            max = Math.max(max, A[i] + i);
        }

        return result;
    }
}
