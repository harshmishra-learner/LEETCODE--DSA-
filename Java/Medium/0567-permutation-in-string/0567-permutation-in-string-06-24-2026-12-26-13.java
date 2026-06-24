class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 > n2) return false;

        // Frequency array for s1
        int[] freq = new int[26];
        for (int i = 0; i < n1; i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        // Iterate through s2 with sliding windows
        for (int i = 0; i <= n2 - n1; i++) {
            int[] windowFreq = new int[26];
            
            // Build the frequency map for the current window
            for (int j = 0; j < n1; j++) {
                windowFreq[s2.charAt(i + j) - 'a']++;
            }

            // Compare both frequency arrays
            if (isFrequencySame(freq, windowFreq)) {
                return true;
            }
        }

        return false;
    }

    // Helper function to compare two frequency arrays [00:17:43]
    private boolean isFrequencySame(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
}