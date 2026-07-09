class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoids potential integer overflow

            // 1. Check if the middle element is our target
            if (nums[mid] == target) {
                return mid;
            }

            // 2. Identify which half is sorted
            if (nums[low] <= nums[mid]) {
                // Left half is perfectly sorted
                
                // Check if the target lies within this sorted left portion
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // Narrow search to the left
                } else {
                    low = mid + 1;  // Target must be in the right half
                }
            } else {
                // Right half must be perfectly sorted
                
                // Check if the target lies within this sorted right portion
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;  // Narrow search to the right
                } else {
                    high = mid - 1; // Target must be in the left half
                }
            }
        }

        // Target was not found in the array
        return -1;
    }
}