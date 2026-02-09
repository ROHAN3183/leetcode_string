class Solution {
    int idx = 0;

    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderStoring(root, list);
        Collections.sort(list);
        recover(root, list);
        return;
    }

    void inorderStoring(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderStoring(root.left, list);
        list.add(root.val);
        inorderStoring(root.right, list);
        return;
    }

    void recover(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        recover(root.left, list);

        root.val = list.get(idx++);

        recover(root.right, list);

        return;

    }
}