class Solution {
    public int compress(char[] chars) {
        int write = 0;
        int i = 0;
        
        while (i < chars.length) {
            int j = i;
            // Find the end of the current group
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            
            int count = j - i;
            // Write the character
            chars[write++] = chars[i];
            
            // Mathematically write the digits in-place
            if (count > 1) {
                int startDigitIndex = write;
                
                // Extract digits backward
                while (count > 0) {
                    chars[write++] = (char) ((count % 10) + '0');
                    count /= 10;
                }
                
                // Reverse the digits to correct the order (e.g., "21" -> "12")
                reverse(chars, startDigitIndex, write - 1);
            }
            
            // Move pointer to the start of the next group
            i = j;
        }
        
        return write;
    }
    
    // Helper function to reverse a segment of the array in-place
    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}