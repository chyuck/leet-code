package solutions;

/**
 * Solution for https://leetcode.com/problems/add-binary/ problem with
 * Time complexity: O(max(A,B))
 * Space complexity: O(max(A,B))
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int digit1 = getDigit(a, i);
            int digit2 = getDigit(b, j);

            int sum = digit1 + digit2 + carry;
            int newDigit = sum % 2;
            carry = sum / 2;

            result.insert(0, newDigit);

            i--;
            j--;
        }

        if (carry == 1) {
            result.insert(0, carry);
        }

        return result.toString();
    }

    private int getDigit(String s, int index) {
        if (index < 0) {
            return 0;
        }

        return s.charAt(index) == '1' ? 1 : 0;
    }
}
