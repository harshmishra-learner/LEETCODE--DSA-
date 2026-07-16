class Solution {
    // Variable to keep track of the maximum diameter found
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return maxDiameter;
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively find the height of left and right subtrees
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Update the maximum diameter if the path through the current node is larger
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return the height of the current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}