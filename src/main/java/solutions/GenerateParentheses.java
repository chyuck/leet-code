package solutions;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();

        if (n == 0) return result;

        backtrack(result, "", 0, 0, n);

        return result;
    }

    private void backtrack(ArrayList<String> result, String current, int open, int close, int n) {
        if (current.length() == n * 2)
            result.add(current);

        if (open < n) backtrack(result, current + "(", open + 1, close, n);
        if (close < n && close < open) backtrack(result, current + ")", open, close + 1, n);
    }
}
