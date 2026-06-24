public class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastSeen = {-1, -1, -1}; 
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // Update the last seen index for the current character
            lastSeen[s.charAt(i) - 'a'] = i;

            // Find the character that appeared furthest back
            int minIndex = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
            
            // Add the total number of valid prefix combinations
            count += (minIndex + 1);
        }
        return count;
    }
}