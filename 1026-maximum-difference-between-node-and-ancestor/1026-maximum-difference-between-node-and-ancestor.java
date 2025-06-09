class Solution {
    public int maxAncestorDiff(TreeNode root) {
        int result = maxAncestor(root, root.val, root.val);
        return result;

    }

    int maxAncestor(TreeNode root, int maxVal, int minVal) {
        if (root == null) {
            return Math.abs(maxVal - minVal);
        }
        maxVal = Math.max(maxVal, root.val);
        minVal = Math.min(minVal, root.val);
        int left = maxAncestor(root.left, maxVal, minVal);
        int right = maxAncestor(root.right, maxVal, minVal);
        return Math.max(left, right);
    }
}