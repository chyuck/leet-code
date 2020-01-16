package solutions;

/**
 * Solution for https://leetcode.com/problems/count-primes/ problem with
 * Time complexity: O(n ^ 2)
 * Space complexity: O(n)
 */
public class CountPrimes {

    /**
     * Algorithm taken from https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     */
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }

        boolean[] primes = new boolean[n];
        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int i = 2; i < n; i++) {
            if (!primes[i]) {
                continue;
            }

            for (int j = i * 2; j < n; j += i) {
                primes[j] = false;
            }
        }

        int count = 0;

        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                count++;
            }
        }

        return count;
    }
}
