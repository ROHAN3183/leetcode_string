class Solution {
    int maxLength = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxLength;

    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0
        }

        int leftTraverse = dfs(root.left);
        int rightTraverse = dfs(root.right);

        int leftpath = 0;
        int rightpath = 0;

        if (root.left != null && root.val == root.left.val) {
            leftpath = leftTraverse + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            rightpath = rightTraverse + 1;
        }
        maxLength = Math.max(maxLength, leftpath + rightpath);

        return Math.max(leftpath, rightpath);
    }
}