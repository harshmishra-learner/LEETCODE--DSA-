class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        // We run the loop until low and high converge to a single element
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            // Check if we are on an ascending slope
            if (nums[mid] < nums[mid + 1]) {
                // The peak must be on the right side, excluding mid
                low = mid + 1;
            } else {
                // We are on a descending slope. 
                // The mid element itself could be the peak, or it's to the left.
                high = mid;
            }
        }
        
        // 'low' and 'high' both point to the peak element index
        return low;
    }
}