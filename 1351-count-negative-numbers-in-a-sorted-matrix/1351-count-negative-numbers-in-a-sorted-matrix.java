class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int count = 0;
        int r = 0;
        int c = n - 1;
        
        while (r < m && c >= 0) {
            if (grid[r][c] < 0) {
                // All elements below grid[r][c] in column 'c' are also negative
                count += (m - r);
                c--; // Move left
            } else {
                r++; // Move down
            }
        }
        
        return count;
    }
}