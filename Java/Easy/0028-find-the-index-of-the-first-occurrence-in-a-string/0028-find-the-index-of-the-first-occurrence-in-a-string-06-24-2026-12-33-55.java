class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        
        // No need to check if the remaining haystack is shorter than the needle
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            
            // Check if the needle matches starting from index i
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            
            // If we successfully traversed the entire needle, we found a match
            if (j == m) {
                return i;
            }
        }
        
        return -1;
    }
}