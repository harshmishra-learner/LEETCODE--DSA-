class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        
        while (left < right) {
            // Swap characters using a temporary variable
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            // Move pointers closer to each other
            left++;
            right--;
        }
    }
}