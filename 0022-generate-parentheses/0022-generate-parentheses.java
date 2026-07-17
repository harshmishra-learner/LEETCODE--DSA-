import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, String currentString, int openCount, int closeCount, int max) {
        // Base case: if the string reaches the maximum length required
        if (currentString.length() == max * 2) {
            result.add(currentString);
            return;
        }

        // Rule 1: Add a '(' if we still have opening brackets left to use
        if (openCount < max) {
            backtrack(result, currentString + "(", openCount + 1, closeCount, max);
        }

        // Rule 2: Add a ')' if it won't violate the balance (close < open)
        if (closeCount < openCount) {
            backtrack(result, currentString + ")", openCount, closeCount + 1, max);
        }
    }
}