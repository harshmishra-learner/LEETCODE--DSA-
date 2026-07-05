import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        
        // Edge case handling: if string or words array is empty, return empty list
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();     // Length of each individual word
        int wordCount = words.length;        // Total number of words we need to match
        int totalLen = wordLen * wordCount;  // Total length of a valid concatenated substring
        
        // If the main string is shorter than the combined length of all words, no match is possible
        if (s.length() < totalLen) {
            return result;
        }

        // Step 1: Build a frequency map of the target words
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        // Step 2: Run the sliding window loop 'wordLen' times.
        // This ensures we catch all alignments (e.g., words starting at index 0, 1, or 2 if wordLen is 3).
        for (int i = 0; i < wordLen; i++) {
            int left = i;   // The left boundary of our current sliding window
            int right = i;  // The right boundary of our current sliding window
            int count = 0;  // Keeps track of how many valid words are currently inside the window
            
            // Dynamic map to track word frequencies within the current window
            Map<String, Integer> currentFreq = new HashMap<>();

            // Move the right pointer across the string, stepping forward by 'wordLen' characters each time
            while (right + wordLen <= s.length()) {
                // Extract the next word chunk from the right side of the window
                String word = s.substring(right, right + wordLen);
                right += wordLen; // Advance the right pointer immediately by one word length

                // Case A: The extracted chunk is a valid word from our target list
                if (wordFreq.containsKey(word)) {
                    currentFreq.put(word, currentFreq.getOrDefault(word, 0) + 1);
                    count++;

                    // Case B: We have ingested too many copies of this specific word.
                    // We must contract the window from the left until the count drops back to legal levels.
                    while (currentFreq.get(word) > wordFreq.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentFreq.put(leftWord, currentFreq.get(leftWord) - 1);
                        count--;
                        left += wordLen; // Shrink the window from the left
                    }

                    // Case C: The window contains exactly the required number of valid words
                    if (count == wordCount) {
                        result.add(left); // 'left' marks the correct starting index of this permutation
                        
                        // Slide the window forward by discarding the leftmost word to keep searching
                        String firstWord = s.substring(left, left + wordLen);
                        currentFreq.put(firstWord, currentFreq.get(firstWord) - 1);
                        count--;
                        left += wordLen;
                    }
                } 
                // Case D: The extracted chunk is completely invalid (not present in 'words' array)
                else {
                    currentFreq.clear(); // Reset our current tracking entirely
                    count = 0;           // Reset valid word counter
                    left = right;        // Jump the window directly past this invalid word
                }
            }
        }

        return result;
    }
}