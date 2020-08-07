package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solution for https://leetcode.com/problems/expression-add-operators/ problem with
 * Time complexity: O(?)
 * Space complexity: O(n * 4^n)
 */
public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        if (num.length() == 0) {
            return Collections.emptyList();
        }

        Set<String> results = new HashSet<>();

        backtrack(0, 0, null, num, 0, target, new StringBuilder(), results);

        return new ArrayList<>(results);
    }

    private static final List<Character> OPERATIONS = Arrays.asList('+', '-', '*');

    private static void backtrack(long calculatedResult, long previousNum, Character operation, String num, int index,
        int target, StringBuilder result, Set<String> results) {

        if (index >= num.length()) {
            if (calculatedResult == target) {
                results.add(result.toString());
            }

            return;
        }

        long previousValue = 0;

        for (int i = index; i < num.length(); i++) {
            long value = previousValue * 10 + Character.getNumericValue(num.charAt(i));

            if (operation != null) {
                result.append(operation);
            }
            String valueString = Long.toString(value);
            result.append(valueString);

            long newCalculatedResult = operation == null ? value : calculateNewResult(calculatedResult, previousNum, value, operation);
            long newPreviousNum = operation == null ? value : getNewPreviousNum(previousNum, value, operation);

            for (Character op : OPERATIONS) {
                backtrack(newCalculatedResult, newPreviousNum, op, num, i + 1, target, result, results);
            }

            result.delete(result.length() - valueString.length(), result.length());
            if (operation != null) {
                result.delete(result.length() - 1, result.length());
            }

            if (value == 0) {
                break;
            }

            previousValue = value;
        }
    }

    private static long getNewPreviousNum(long previousNum, long value, Character operation) {
        switch (operation) {
            case '+': return value;
            case '-': return -value;
            case '*': return previousNum * value;
            default: throw new RuntimeException();
        }
    }

    private static long calculateNewResult(long calculatedResult, long previousNum, long value, Character operation) {
        switch (operation) {
            case '+': return calculatedResult + value;
            case '-': return calculatedResult - value;
            case '*': return calculatedResult - previousNum + previousNum * value;
            default: throw new RuntimeException();
        }
    }
}
