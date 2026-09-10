class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        
        // Find the maximum value in nums for the upper bound
        for (int num : nums) {
            high = Math.max(high, num);
        }
        
        int ans = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (getSum(nums, mid) <= threshold) {
                ans = mid;        // Candidate found, try to find a smaller divisor
                high = mid - 1;
            } else {
                low = mid + 1;    // Sum is too large, need a bigger divisor
            }
        }
        
        return ans;
    }
    
    private int getSum(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor; // Ceiling division
        }
        return sum;
    }
}