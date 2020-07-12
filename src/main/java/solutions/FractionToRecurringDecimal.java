package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/fraction-to-recurring-decimal/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class FractionToRecurringDecimal {

    private static class Fraction {
        private long numerator;
        private final long denominator;

        private Fraction(long numerator, long denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        addSign(numerator, denominator, result);

        Fraction fraction = new Fraction(Math.abs((long) numerator), Math.abs((long)denominator));
        addDecimal(fraction, result);

        return result.toString();
    }

    private static void addSign(int numerator, int denominator, StringBuilder result) {
        if ((numerator < 0) != (denominator < 0)) {
            result.append('-');
        }
    }

    private static void addDecimal(Fraction fraction, StringBuilder result) {

        addNumber(fraction, result);
        if (fraction.numerator == 0) {
            return;
        }

        result.append('.');
        addFractionalPart(fraction, result);
    }

    private static void addNumber(Fraction fraction, StringBuilder result) {
        if (fraction.numerator < fraction.denominator) {
            result.append('0');
        } else {
            long number = fraction.numerator / fraction.denominator;
            result.append(number);
            fraction.numerator %= fraction.denominator;
        }

        fraction.numerator *= 10;
    }

    private static void addFractionalPart(Fraction fraction, StringBuilder result) {
        Map<Long, Integer> indexes = new HashMap<>();

        while (fraction.numerator > 0) {
            Integer index = indexes.get(fraction.numerator);
            if (index != null) {
                result.insert(index, "(").append(')');
                return;
            }

            indexes.put(fraction.numerator, result.length());

            addNumber(fraction, result);
        }
    }
}
