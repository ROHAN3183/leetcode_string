class Solution {
    List<Integer> list;
    int idx = 0;

    public void recoverTree(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        Collections.sort(list);
        recover(root);
        return;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
        return;

    }

    void recover(TreeNode root) {
        if (root == null) {
            return;
        }
        recover(root.left);
        root.val = list.get(idx++);
        recover(root.right);
        return;

    }
}