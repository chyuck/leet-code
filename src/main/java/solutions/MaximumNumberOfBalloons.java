package solutions;

public class MaximumNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        if (text == null || text.length() < 7) return 0;

        // counts for b,a,l,o,n
        int[] counts = new int[5];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch == 'b') counts[0]++;
            else if (ch == 'a') counts[1]++;
            else if (ch == 'l') counts[2]++;
            else if (ch == 'o') counts[3]++;
            else if (ch == 'n') counts[4]++;
        }

        // for l and o divide by 2
        counts[2] /= 2;
        counts[3] /= 2;

        int result = Integer.MAX_VALUE;
        for (int count: counts) {
            result = Math.min(result, count);
        }

        return result;
    }
}
