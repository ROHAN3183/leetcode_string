class Solution {
    List<Integer> list;
    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        return dfs(list, 0, list.size() - 1);
    }

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
        
        return;
    }

    TreeNode dfs(List<Integer> list, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = dfs(list, low, mid - 1);
        root.right = dfs(list, mid + 1, high);
        return root;
    }
}