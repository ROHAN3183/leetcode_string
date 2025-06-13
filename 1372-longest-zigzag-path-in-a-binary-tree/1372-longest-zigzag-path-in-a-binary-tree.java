class Solution {
    int MaxLength = 0;

    public int longestZigZag(TreeNode root) {
        traverse(root.left, 1, true);
        traverse(root.right, 1, false);
        return MaxLength;

    }

    void traverse(TreeNode root, int idx, boolean isLeft) {
        if (root == null) {
            return;
        }
        MaxLength = Math.max(MaxLength, idx);

        if (isLeft) {
            traverse(root.right, idx + 1, false);
            traverse(root.left, 1, true);

        } else {
            traverse(root.left, idx + 1, true);
            traverse(root.right, 1, false);
        }
    }

}