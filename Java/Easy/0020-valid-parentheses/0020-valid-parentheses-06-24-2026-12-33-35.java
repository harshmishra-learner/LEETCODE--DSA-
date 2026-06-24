import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // A valid string must have an even length
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                // If the stack is empty or the top doesn't match the current closing bracket
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        
        // If the stack is empty, all brackets were properly closed
        return stack.isEmpty();
    }
}