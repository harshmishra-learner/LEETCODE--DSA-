class Solution {
    public boolean rotateString(String s, String goal) {
        // Step 1: Check if the lengths are equal.
        // If they aren't, s can never be rotated to match goal.
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Step 2: Concatenate s with itself.
        // This contains every possible rotation of the string s.
        String doubledString = s + s;
        
        // Step 3: Check if 'goal' exists as a substring inside the doubled string.
        return doubledString.contains(goal);
    }
}