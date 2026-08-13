class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case: if root is null or matches either target node
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right return non-null, root is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null result (if any)
        return left != null ? left : right;
    }
}