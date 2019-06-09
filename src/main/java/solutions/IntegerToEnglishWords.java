package solutions;

/**
 * Solution for https://leetcode.com/problems/integer-to-english-words problem with
 * Time complexity: O(n) where n is number of digits
 * Space complexity: O(1)
 */
public class IntegerToEnglishWords {

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        final StringBuilder builder = new StringBuilder();

        // billions
        final int billions = num / 1_000_000_000;
        if (billions > 0) {
            builder.append(numberLessThan10ToWord(billions));
            builder.append(" ");
            builder.append("Billion");
            num -= billions * 1_000_000_000;
        }

        // millions
        final int millions = num / 1_000_000;
        if (millions > 0) {
            if (builder.length() > 0)
                builder.append(" ");
            addWordsForNumberLessThan1000(builder, millions);
            builder.append(" ");
            builder.append("Million");
            num -= millions * 1_000_000;
        }

        // thousands
        final int thousands = num / 1_000;
        if (thousands > 0) {
            if (builder.length() > 0)
                builder.append(" ");
            addWordsForNumberLessThan1000(builder, thousands);
            builder.append(" ");
            builder.append("Thousand");
            num -= thousands * 1_000;
        }

        // hundreds, tens etc
        if (num > 0) {
            if (builder.length() > 0)
                builder.append(" ");
            addWordsForNumberLessThan1000(builder, num);
        }

        return builder.toString();
    }

    private static void addWordsForNumberLessThan1000(StringBuilder builder, int num) {
        // number from 0 to 99
        if (num <= 99) {
            addWordsForNumberLessThan100(builder, num);
            return;
        }

        // number from 100 to 999
        final int hundreds = num / 100;
        builder.append(numberLessThan10ToWord(hundreds));
        builder.append(" ");
        builder.append("Hundred");

        final int lastTwoDigits = num - hundreds * 100;
        if (lastTwoDigits == 0)
            return;
        builder.append(" ");
        addWordsForNumberLessThan100(builder, lastTwoDigits);
    }

    private static void addWordsForNumberLessThan100(StringBuilder builder, int num) {
        // number from 0 to 9
        if (num <= 9) {
            builder.append(numberLessThan10ToWord(num));
            return;
        }

        // number from 10 to 19
        if (num <= 19) {
            builder.append(numberBetween10And19ToWord(num));
            return;
        }

        // number from 20 to 99
        final int tens = num / 10;
        builder.append(numberOfTensBetween2And9ToWord(tens));

        final int lastDigit = num - tens * 10;
        if (lastDigit == 0)
            return;
        builder.append(" ");
        builder.append(numberLessThan10ToWord(lastDigit));
    }

    private static String numberOfTensBetween2And9ToWord(int tens) {
        switch (tens) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }

        throw new IllegalArgumentException("num must be between 2 and 9.");
    }

    private static String numberBetween10And19ToWord(int num) {
        switch (num) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }

        throw new IllegalArgumentException("num must be between 10 and 19.");
    }

    private static String numberLessThan10ToWord(int num) {
        switch (num) {
            case 0: return "";
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }

        throw new IllegalArgumentException("num must be between 0 and 19.");
    }
}
