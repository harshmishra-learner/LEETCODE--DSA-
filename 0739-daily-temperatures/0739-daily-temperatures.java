import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        // Stack will store the *indices* of the days
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            // While stack is not empty AND current temperature is warmer 
            // than the temperature of the day on top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex; // Number of days waited
            }
            // Push the current day's index onto the stack
            stack.push(i);
        }
        
        return result;
    }
}