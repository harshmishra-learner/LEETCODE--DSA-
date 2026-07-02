import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        
        for (int i = 0; i <= n; i++) {
            // Treat the end of the array (i == n) as a bar of height 0 
            // to force the cleanup of remaining elements in the stack.
            int currentHeight = (i == n) ? 0 : heights[i];
            
            // Maintain a monotonic increasing stack
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                
                // If stack is empty, it means this bar was the smallest seen so far,
                // so its left boundary is effectively index -1.
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                int width = i - leftBoundary - 1;
                
                maxArea = Math.max(maxArea, height * width);
            }
            
            stack.push(i);
        }
        
        return maxArea;
    }
}