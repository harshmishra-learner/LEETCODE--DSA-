class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            // Skip already visited/processed dead-end elements
            if (nums[i] == 0) {
                continue;
            }
            
            int slow = i;
            int fast = i;
            boolean isForward = nums[i] > 0;
            
            // Loop until fast and slow meet, or an invalid step occurs
            while (true) {
                slow = getNextIndex(slow, isForward, nums);
                fast = getNextIndex(fast, isForward, nums);
                
                if (fast != -1) {
                    fast = getNextIndex(fast, isForward, nums);
                }
                
                // If either pointer hits an invalid step or a self-loop, break
                if (slow == -1 || fast == -1 || slow == getNextIndex(slow, isForward, nums)) {
                    break;
                }
                
                // Cycle detected!
                if (slow == fast) {
                    return true;
                }
            }
            
            // Optimization: Mark all nodes in this invalid path as 0
            int curr = i;
            while (nums[curr] != 0 && (nums[curr] > 0) == isForward) {
                int next = getNextIndex(curr, isForward, nums);
                nums[curr] = 0;
                if (next == -1) break;
                curr = next;
            }
        }
        
        return false;
    }
    
    // Helper function to calculate the next circular index
    private int getNextIndex(int curr, boolean isForward, int[] nums) {
        int n = nums.length;
        boolean currDirection = nums[curr] > 0;
        
        // Condition 1: Direction mismatch means invalid step
        if (isForward != currDirection) {
            return -1;
        }
        
        // Handle circular wrapping safely for both positive and negative steps
        int next = ((curr + nums[curr]) % n + n) % n;
        
        // Condition 2: Self-loop (cycle of length 1) is invalid
        if (next == curr) {
            return -1;
        }
        
        return next;
    }
}