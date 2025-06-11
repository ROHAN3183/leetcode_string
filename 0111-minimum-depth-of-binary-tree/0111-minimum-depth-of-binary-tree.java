class Solution {
    int minValue = (int) Math.pow(10, 5);

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root, 1);
        return minValue;

    }

    void traverse(TreeNode root, int level) {
        if (root.left == null && root.right == null) {
            minValue = Math.min(minValue, level);
            return;
        }
        if (root.left != null)
            traverse(root.left, level + 1);
        if (root.right != null)
            traverse(root.right, level + 1);

    }
}