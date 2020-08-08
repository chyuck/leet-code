package solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/maximum-swap/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 * where n - number of digits
 */
public class MaximumSwap {

    public int maximumSwap(int num) {
        int[] digits = getDigits(num);
        Map<Integer, Integer> lastIndexes = getLastIndexes(digits);

        for (int i = 0; i < digits.length; i++) {
            int digit = digits[i];

            for (int lastDigit = 9; lastDigit > digit; lastDigit--) {
                Integer lastIndex = lastIndexes.get(lastDigit);

                if (lastIndex != null && i < lastIndex) {
                    digits[i] = lastDigit;
                    digits[lastIndex] = digit;

                    return getNumber(digits);
                }
            }
        }

        return getNumber(digits);
    }

    private int[] getDigits(int num) {
        LinkedList<Integer> digits = new LinkedList<>();

        while (num > 0) {
            int digit = num % 10;
            digits.addFirst(digit);
            num /= 10;
        }

        int[] result = new int[digits.size()];
        int index = 0;
        for (Integer digit : digits) {
            result[index] = digit;
            index++;
        }

        return result;
    }

    private Map<Integer, Integer> getLastIndexes(int[] digits) {
        Map<Integer, Integer> result = new HashMap<>();

        for (int i = 0; i < digits.length; i++) {
            int digit = digits[i];
            result.put(digit, i);
        }

        return result;
    }

    private int getNumber(int[] digits) {
        int result = 0;

        for (int i = 0; i < digits.length; i++) {
            result = result * 10 + digits[i];
        }

        return result;
    }
}
