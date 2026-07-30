class Solution {
    public int maxDepth(TreeNode root) {
        // Base case: An empty tree has depth 0
        if (root == null) {
            return 0;
        }

        // Recursively find the max depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Return 1 (current node) + the maximum depth between subtrees
        return 1 + Math.max(leftDepth, rightDepth);
    }
}