public class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26]; // To store frequency of characters 'A' through 'Z'
        int low = 0;
        int maxCount = 0; // Tracks the highest frequency of a single character in the current window
        int maxLength = 0; // Tracks the maximum length of a valid window

        // 'high' acts as the end pointer of the sliding window
        for (int high = 0; high < s.length(); high++) {
            // Include the current character in the window
            freq[s.charAt(high) - 'A']++;
            
            // Update maxCount with the maximum frequency seen in the current window
            maxCount = Math.max(maxCount, freq[s.charAt(high) - 'A']);

            // If the number of characters to replace exceeds k, shrink the window from the left
            int currentWindowLength = high - low + 1;
            if (currentWindowLength - maxCount > k) {
                freq[s.charAt(low) - 'A']--; // Remove the character at 'low' from frequency
                low++; // Move the left pointer forward
            }

            // Since the window only expands or stays the same size when valid, 
            // the max valid window size is recorded properly
            maxLength = Math.max(maxLength, high - low + 1);
        }

        return maxLength;
    }
}