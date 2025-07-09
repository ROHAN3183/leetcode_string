class Solution {
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        idx = postorder.length - 1;
        return dfs(inorder, postorder, map, 0, postorder.length - 1);
    }

    TreeNode dfs(int[] inorder, int[] postorder, HashMap<Integer, Integer> map, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootVal = postorder[idx--];
        int range = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.right = dfs(inorder, postorder, map, range + 1, end);
        root.left = dfs(inorder, postorder, map, start, range - 1);

        return root;

    }
}