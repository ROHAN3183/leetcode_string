class Solution {
    int Totaltilt = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return Totaltilt;
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        
        Totaltilt += Math.abs(left - right);

        return root.val + left + right;
    }
}