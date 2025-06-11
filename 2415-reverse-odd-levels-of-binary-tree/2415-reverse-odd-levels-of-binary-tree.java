class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        reversed(root.left, root.right, 1);
        return root;
    }

    void reversed(TreeNode node1, TreeNode node2, int idx) {
        if (node1 == null || node2 == null) {
            return;
        }
        if (idx % 2 != 0) {
            swap(node1, node2);
        }
        reversed(node1.left, node2.right, idx + 1);
        reversed(node1.right, node2.left, idx + 1);
    }

    void swap(TreeNode nodeStart, TreeNode nodeEnd) {
        int temp = nodeStart.val;
        nodeStart.val = nodeEnd.val;
        nodeEnd.val = temp;
    }
}
