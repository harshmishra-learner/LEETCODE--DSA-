class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        // Step 1: Use an integer array instead of HashMap for target frequencies.
        // ASCII size 128 covers all English letters and common symbols.
        int[] targetCounts = new int[128];
        for (char c : t.toCharArray()) {
            targetCounts[c]++;
        }

        // Array to track characters in the current sliding window
        int[] windowCounts = new int[128];
        
        // Count how many unique characters in 't' actually need to be matched
        int required = 0;
        for (int count : targetCounts) {
            if (count > 0) required++;
        }

        int formed = 0;
        int left = 0;
        
        // Track the best window performance: {length, leftIndex, rightIndex}
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;
        int endIdx = 0;

        // Step 2: Expand the window using the 'right' pointer
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            windowCounts[rightChar]++;

            // If the current character completes its required target frequency
            if (targetCounts[rightChar] > 0 && windowCounts[rightChar] == targetCounts[rightChar]) {
                formed++;
            }

            // Step 3: Shrink the window from the left if it's valid
            while (left <= right && formed == required) {
                char leftChar = s.charAt(left);

                // Update the minimum window coordinates
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                    endIdx = right;
                }

                // Remove the leftmost character from our window tracking
                windowCounts[leftChar]--;
                
                // If removing this character breaks the target criteria, decrement 'formed'
                if (targetCounts[leftChar] > 0 && windowCounts[leftChar] < targetCounts[leftChar]) {
                    formed--;
                }

                // Move the left pointer forward
                left++;
            }
        }

        // Step 4: Return the optimal substring or empty string if no window was found
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, endIdx + 1);
    }
}