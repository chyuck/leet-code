package solutions;

/**
 * Solution for https://leetcode.com/problems/excel-sheet-column-number/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int result = 0;
        int multiplier = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            int number = s.charAt(i) - 'A' + 1;
            result += multiplier * number;
            multiplier *= 'Z' - 'A' + 1;
        }

        return result;
    }
}
