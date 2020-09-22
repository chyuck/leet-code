package solutions;

/**
 * Solution for https://leetcode.com/problems/divide-chocolate/ problem with
 * Time complexity: O(N * log(S))
 * Space complexity: O(1)
 * where N - number of elements in "sweetness" array, S - sum of elements in sweetness array divided by K
 */
public class DivideChocolate {

    public int maximizeSweetness(int[] sweetness, int K) {
        int low = 1, high = getSum(sweetness) / (K + 1);

        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (canSplit(sweetness, K, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private static boolean canSplit(int[] sweetness, int K, int targetSweetness) {
        int chunks = 0, sweet = 0;

        for (int s : sweetness) {
            sweet += s;

            if (sweet >= targetSweetness) {
                chunks++;
                if (chunks > K) {
                    return true;
                }

                sweet = 0;
            }
        }

        return false;
    }

    private static int getSum(int[] sweetness) {
        int result = 0;

        for (int s : sweetness) {
            result += s;
        }

        return result;
    }
}
