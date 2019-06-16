package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/letter-combinations-of-a-phone-number problem with
 * Time complexity: O(3^n * 4^m)
 * Space complexity: O(3^n * 4^m)
 * where n - number of digits with 3 letters, m - number of digits with 4 letters
 * n + m = length of digits
 */
public class LettersOfPhoneNumber {

    private Map<String, String[]> digitToLetters = new HashMap<String, String[]>() {{
        put("2", new String[] {"a","b","c"});
        put("3", new String[] {"d","e","f"});
        put("4", new String[] {"g","h","i"});
        put("5", new String[] {"j","k","l"});
        put("6", new String[] {"m","n","o"});
        put("7", new String[] {"p","q","r","s"});
        put("8", new String[] {"t","u","v"});
        put("9", new String[] {"w","x","y","z"});
    }};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();

        List<String> results = new ArrayList<>();

        // start from empty combination and add one by one all possible letters for each digits
        // create different combinations for each letter of particular digit
        // when combination is full add it to result list
        backtrack("", digits, results);

        return results;
    }

    private void backtrack(String combination, String digits, List<String> results) {
        // end of backtracking for current combination, add to result
        if (digits.isEmpty()) {
            results.add(combination);
            return;
        }

        String firstDigit = digits.substring(0, 1);
        String nextDigits = digits.length() > 1 ? digits.substring(1) : "";

        for (String letter: digitToLetters.get(firstDigit)) {
            String nextCombination = combination + letter;
            // call recursively for combination with added letter for first digit from digits
            // and digits without first digit
            backtrack(nextCombination, nextDigits, results);
        }
    }
}
