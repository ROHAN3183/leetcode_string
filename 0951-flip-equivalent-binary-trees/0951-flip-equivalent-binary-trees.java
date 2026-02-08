class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    boolean dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        boolean flip = dfs(root1.left, root2.right) && dfs(root1.right, root2.left);
        boolean withoutflip = dfs(root1.left, root2.left) && dfs(root1.right, root2.right);
        return flip || withoutflip;
    }
}