package solutions;

/**
 * Solution for https://leetcode.com/problems/min-cost-climbing-stairs problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        // if only 2 costs, then return min cost od them
        if (cost.length == 2) return Math.min(cost[0], cost[1]);

        // formula is total[i] = cost[i] + min(total[i+1], total[i+2])

        // set initial values for total[i+1] and total[i+2]
        int nextTotal = cost[cost.length - 2];
        int nextNextTotal = cost[cost.length - 1];

        // loop from end until beginning
        for (int i = cost.length - 3; i >= 0; i--) {
            // apply formula
            int currentTotal = cost[i] + Math.min(nextTotal, nextNextTotal);

            // prepare total[i+1] and total[i+2] for next iteration
            nextNextTotal = nextTotal;
            nextTotal = currentTotal;
        }

        // at the end next total will have total[0] and next next total will have total[1]
        // return min cost of total[0] and total[1]
        return Math.min(nextTotal, nextNextTotal);
    }
}
