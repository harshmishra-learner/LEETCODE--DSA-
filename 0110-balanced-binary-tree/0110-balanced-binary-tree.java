class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        // Base case: Empty tree has height 0
        if (node == null) {
            return 0;
        }

        // Get height of left subtree
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1; // Subtree is unbalanced

        // Get height of right subtree
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1; // Subtree is unbalanced

        // Check if current node is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is unbalanced
        }

        // Return height of current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}