class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        int pos = 0; // Pointer for positive numbers (even indices)
        int neg = 1; // Pointer for negative numbers (odd indices)
        
        for (int num : nums) {
            if (num > 0) {
                ans[pos] = num;
                pos += 2;
            } else {
                ans[neg] = num;
                neg += 2;
            }
        }
        
        return ans;
    }
}