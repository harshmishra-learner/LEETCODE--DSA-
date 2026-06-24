class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        
        int left = 0;
        int currentSum = 0;

        // 'right' pointer expands the sliding window
        for (int right = 0; right < n; right++) {
            currentSum += nums[right];

            // Contract the window from the left as long as the condition is met
            while (currentSum >= target) {
                // Update the minimal length found so far
                minLength = Math.min(minLength, right - left + 1);
                
                // Shrink the window and subtract the element leaving the window
                currentSum -= nums[left];
                left++;
            }
        }

        // If minLength was never updated, return 0
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}