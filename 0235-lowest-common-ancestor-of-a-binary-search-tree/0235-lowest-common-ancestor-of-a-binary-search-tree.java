class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while (curr != null) {
            if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left; // Both nodes are in the left subtree
            } else if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right; // Both nodes are in the right subtree
            } else {
                return curr; // Split point found or curr is equal to p or q
            }
        }
        return null;
    }
}