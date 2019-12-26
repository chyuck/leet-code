package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Solutions for https://leetcode.com/problems/happy-number/ problem with
 * Time complexity: O(n)
 */
public class HappyNumber {

    /**
     * Space complexity: O(1)
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while (true) {
            if (fast == 1) {
                return true;
            }
            if (slow == fast) {
                return false;
            }

            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
    }

    /**
     * Space complexity: O(n)
     */
    public boolean isHappy2(int n) {
        Set<Integer> set = new HashSet<>();

        while (true) {
            if (n == 1) {
                return true;
            }

            if (set.contains(n)) {
                return false;
            }

            set.add(n);
            n = getNext(n);
        }
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
