class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;

    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftpath = dfs(root.left);
        int rightpath = dfs(root.right);
        int curve=leftpath+rightpath+root.val;

        int rootMax = root.val;
        int sideMax = Math.max(leftpath, rightpath) + root.val;
        maxSum=Math.max(maxSum,Math.max(curve,Math.max(rootMax,sideMax)));
        return Math.max(rootMax, sideMax);

    }
}