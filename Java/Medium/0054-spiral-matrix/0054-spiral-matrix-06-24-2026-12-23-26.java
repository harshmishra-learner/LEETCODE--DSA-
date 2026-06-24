class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }

        int n = matrix.length;   
        int m = matrix[0].length; 

        int top = 0, left = 0;
        int bottom = n - 1, right = m - 1;

        while (top <= bottom && left <= right) {
            // Move Right
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++; 

            // Move Down
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--; 

            // Move Left (Check if row still exists)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--; 
            }

            // Move Up (Check if column still exists)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++; 
            }
        }

        return ans;
    }
}
