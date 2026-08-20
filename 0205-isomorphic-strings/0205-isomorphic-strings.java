class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] lastSeenS = new int[256];
        int[] lastSeenT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (lastSeenS[s.charAt(i)] != lastSeenT[t.charAt(i)]) {
                return false;
            }
            // Store current index + 1 to distinguish from default 0
            lastSeenS[s.charAt(i)] = i + 1;
            lastSeenT[t.charAt(i)] = i + 1;
        }

        return true;
    }
}