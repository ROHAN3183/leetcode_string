class Solution {
    int min = Integer.MAX_VALUE;
    int prev = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        min = Math.min(min, Math.abs(root.val - prev));
        prev = root.val;
        dfs(root.right);

        return;
    }
}