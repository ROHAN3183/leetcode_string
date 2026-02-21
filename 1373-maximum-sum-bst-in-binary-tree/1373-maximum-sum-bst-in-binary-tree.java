class Solution {
    class info {
        boolean isvalid;
        int min;
        int max;
        int sum;

        info(boolean isvalid, int min, int max, int sum) {
            this.isvalid = isvalid;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    int maxSum;

    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        dfs(root);
        return maxSum;

    }

    info dfs(TreeNode root) {
        if (root == null) {
            return new info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        info left = dfs(root.left);
        info right = dfs(root.right);

        int min = Math.min(left.min, root.val);
        int max = Math.max(right.max, root.val);
        int sum = left.sum + right.sum + root.val;

        if (left.isvalid && right.isvalid && root.val > left.max && root.val < right.min) {
            maxSum = Math.max(maxSum, sum);
            return new info(true, min, max, sum);
        }
        return new info(false, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
}