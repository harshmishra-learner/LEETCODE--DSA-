class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // Edge case: if k is 0 or 1, no product of positive integers can be strictly less than k
        if (k <= 1) return 0;
        
        int count = 0;
        int product = 1;
        int left = 0;
        
        // Expand the window using the right pointer
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            
            // Shrink the window from the left if the product is too large
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            
            // All subarrays ending at 'right' and starting from 'left' up to 'right' are valid
            count += (right - left + 1);
        }
        
        return count;
    }
}