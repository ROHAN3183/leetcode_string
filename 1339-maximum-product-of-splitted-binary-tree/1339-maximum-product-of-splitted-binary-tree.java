class Solution {
    long maxValue = 0;
    int totalSum = 0;

    public int maxProduct(TreeNode root) {
        totalSum = TotalSum(root);
        traverse(root);
        return (int ) maxValue% 1000000007;
    }

    int TotalSum(TreeNode root) {
        if (root == null)
            return 0;

        int left = TotalSum(root.left);
        int right =TotalSum(root.right);

        return left + right + root.val;
    }

    int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        int subtreeSum = left + right + root.val;
        int product = subtreeSum * (totalSum - subtreeSum);
        maxValue = Math.max(maxValue, product);
        return subtreeSum;
    }
}
