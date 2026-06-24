public class Solution {
    public boolean isPalindrome(String s) {
        int st = 0;
        int end = s.length() - 1;

        while (st < end) {
            char currStart = s.charAt(st);
            char currEnd = s.charAt(end);
            if (!Character.isLetterOrDigit(currStart)) {
                st++;
            } 
            
            else if (!Character.isLetterOrDigit(currEnd)) {
                end--;
            } 
            else {
                if (Character.toLowerCase(currStart) != Character.toLowerCase(currEnd)) {
                    return false; 
                }
                st++;
                end--;
            }
        }
        return true; 
    }
}