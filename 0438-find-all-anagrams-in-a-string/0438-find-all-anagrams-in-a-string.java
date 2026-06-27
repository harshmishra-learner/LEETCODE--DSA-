class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        // Edge case
        if (s.length() < p.length()) {
            return result;
        }
        
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        
        // Build the frequency for p and the first window of s
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        
        // Slide the window across string s
        for (int i = p.length(); i < s.length(); i++) {
            // If the current window matches p's frequency, record the start index
            if (matches(pCount, sCount)) {
                result.add(i - p.length());
            }
            
            // Add the next character to the window
            sCount[s.charAt(i) - 'a']++;
            // Remove the oldest character from the window
            sCount[s.charAt(i - p.length()) - 'a']--;
        }
        
        // Check the last window
        if (matches(pCount, sCount)) {
            result.add(s.length() - p.length());
        }
        
        return result;
    }
    
    // Helper method to compare two frequency arrays
    private boolean matches(int[] pCount, int[] sCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != sCount[i]) {
                return false;
            }
        }
        return true;
    }
}