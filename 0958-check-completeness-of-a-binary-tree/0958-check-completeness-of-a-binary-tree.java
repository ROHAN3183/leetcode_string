class Solution {
    public boolean isCompleteTree(TreeNode root) {
        List<Object[]> ans = new ArrayList<>();
        traverse(root, ans, 1);
        int totalNodes = ans.size();
        int lastIndex = (int) ans.get(totalNodes - 1)[1];
        // If the last index matches total nodes, tree is complete
        return lastIndex == totalNodes;
    }

    void traverse(TreeNode root, List<Object[]> ans, int idx) {
        if (root == null) {
            return;
        }
        ans.add(new Object[]{root, idx});
        traverse(root.left, ans, 2 * idx);
        traverse(root.right, ans, 2 * idx + 1);
    }
}