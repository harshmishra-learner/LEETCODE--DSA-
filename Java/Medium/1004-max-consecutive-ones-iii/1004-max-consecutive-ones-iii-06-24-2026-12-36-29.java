public class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        int zeros = 0;
        int maxLen = 0;

        // Iterate through the array using the right pointer
        while (r < n) {
            if (nums[r] == 0) {
                zeros++;
            }

            // Instead of a while loop, use an 'if' to shift 'l' by at most 1 position per step
            if (zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++; // Shrink by 1, maintaining the maximum window size achieved so far
            }

            // Only update maxLen if the current window configuration is completely valid
            if (zeros <= k) {
                int len = r - l + 1;
                maxLen = Math.max(maxLen, len);
            }
            r++; // Move the right pointer forward
        }
        return maxLen;
    }
}