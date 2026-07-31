class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // Base Cases
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;

        // Compare t1's left with t2's right AND t1's right with t2's left
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}