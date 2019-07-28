package solutions;

/**
 * Solution for https://leetcode.com/problems/word-search/ problem with
 * Time complexity: O(n * log(log(n)))
 * Space complexity: O(n)
 */
public class CountPrimes {

    /**
     * Algorithm taken from https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     */
    public int countPrimes(int n) {
        // there is no prime numbers less than 2
        if (n <= 2) return 0;

        // create array of flags for each number less than n
        // by default set all numbers as prime
        boolean[] isPrimes = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrimes[i] = true;
        }

        // set flags for all non prime numbers as false
        // loop until sqrt(n) because all greater numbers than sqrt(n) should be already marked (see inner loop)
        for (int i = 2; i * i < n; i++) {
            // skip already processed number
            if (!isPrimes[i]) continue;

            // set flags as false for all numbers multiples of i
            // start from i * i, because for all factors less than i, numbers were already marked
            for (int j = i * i; j < n; j += i) {
                isPrimes[j] = false;
            }
        }

        // count all prime numbers and return result
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                count++;
            }
        }

        return count;
    }
}
