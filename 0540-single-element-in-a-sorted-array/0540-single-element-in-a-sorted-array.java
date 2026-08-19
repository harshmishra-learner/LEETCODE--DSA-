class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // mid ^ 1 checks the adjacent partner index based on even/odd parity
            if (nums[mid] == nums[mid ^ 1]) {
                left = mid + 1; // Single element is further right
            } else {
                right = mid;    // Single element is at mid or further left
            }
        }

        return nums[left];
    }
}