import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1); // Default to -1 if no greater element is found
        
        Stack<Integer> stack = new Stack<>(); // Stores indices
        
        // Loop through the array twice to simulate circular behavior
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            
            // Pop elements from stack if the current number is greater
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                ans[stack.pop()] = num;
            }
            
            // Only push indices to the stack during the first pass
            if (i < n) {
                stack.push(i);
            }
        }
        
        return ans;
    }
}