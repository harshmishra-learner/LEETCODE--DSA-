class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirstPosition(nums, target);
        result[1] = findLastPosition(nums, target);
        return result;
    }

    // Binary Search to find the leftmost (first) index of the target
    private int findFirstPosition(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int firstIdx = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                firstIdx = mid;       // Temporarily save the index
                high = mid - 1;       // Keep searching towards the left
            } else if (nums[mid] < target) {
                low = mid + 1;        // Target is in the right half
            } else {
                high = mid - 1;       // Target is in the left half
            }
        }
        return firstIdx;
    }

    // Binary Search to find the rightmost (last) index of the target
    private int findLastPosition(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int lastIdx = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                lastIdx = mid;        // Temporarily save the index
                low = mid + 1;        // Keep searching towards the right
            } else if (nums[mid] < target) {
                low = mid + 1;        // Target is in the right half
            } else {
                high = mid - 1;       // Target is in the left half
            }
        }
        return lastIdx;
    }
}