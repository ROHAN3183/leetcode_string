

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        List<Object[]> ans = new ArrayList<>();
        traverse(root, ans, 1);
        int totalNodes = ans.size();
        if (totalNodes == 0) return true; // empty tree is complete
        int maxIndex = 0;
        for (Object[] nodeInfo : ans) {
            int currentIndex = (int) nodeInfo[1];
            if (currentIndex > maxIndex) {
                maxIndex = currentIndex;
            }
        }
        // If the maximum index matches total nodes, tree is complete
        return maxIndex == totalNodes;
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