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

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return results;
        }

        Map<Character, String[]> digitToLetters = createDigitToLettersMap();

        backtrack("", 0, digits, digitToLetters, results);

        return results;
    }

    private void backtrack(String combination, int index, String digits, Map<Character, String[]> digitToLetters,
        List<String> results) {

        if (index >= digits.length()) {
            results.add(combination);
            return;
        }

        String[] letters = digitToLetters.get(digits.charAt(index));
        for (String letter : letters) {
            backtrack(combination + letter, index + 1, digits, digitToLetters, results);
        }
    }

    private static Map<Character, String[]> createDigitToLettersMap() {
        Map<Character, String[]> result = new HashMap<>();

        result.put('1', new String[] {""});
        result.put('2', new String[] {"a","b","c"});
        result.put('3', new String[] {"d","e","f"});
        result.put('4', new String[] {"g","h","i"});
        result.put('5', new String[] {"j","k","l"});
        result.put('6', new String[] {"m","n","o"});
        result.put('7', new String[] {"p","q","r","s"});
        result.put('8', new String[] {"t","u","v"});
        result.put('9', new String[] {"w","x","y","z"});

        return result;
    }
}
