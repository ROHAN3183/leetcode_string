class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        max = Math.max(max, root.val + Math.max(left, right));
        max = Math.max(max, root.val + left + right);

        if (root.val + Math.max(left, right) < 0) {
            return 0;
        }
        return root.val + Math.max(left, right);
    }
}