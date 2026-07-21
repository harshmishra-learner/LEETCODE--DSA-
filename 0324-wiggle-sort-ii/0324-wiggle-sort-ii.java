import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        
        // Step 1: Copy and sort array
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        
        // Step 2: Set two pointers to end of each half
        int left = (n - 1) / 2; // End of smaller half
        int right = n - 1;       // End of larger half
        
        // Step 3: Interleave elements into the original array
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                // Fill even indices with elements from small half
                nums[i] = sorted[left];
                left--;
            } else {
                // Fill odd indices with elements from large half
                nums[i] = sorted[right];
                right--;
            }
        }
    }
}