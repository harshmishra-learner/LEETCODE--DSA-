class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            // Using this formula avoids potential integer overflow bugs
            int mid = low + (high - low) / 2; 
            
            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                low = mid + 1; // Target is in the right half
            } else {
                high = mid - 1; // Target is in the left half
            }
        }
        
        return -1; // Target does not exist
    }
}