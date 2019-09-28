package solutions;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) return true;

        int left = 0, right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            if (!isAlphaNumeric(leftChar)) {
                left++;
                continue;
            }

            char rightChar = s.charAt(right);
            if (!isAlphaNumeric(rightChar)) {
                right--;
                continue;
            }

            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar))
                return false;

            left++;
            right--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
