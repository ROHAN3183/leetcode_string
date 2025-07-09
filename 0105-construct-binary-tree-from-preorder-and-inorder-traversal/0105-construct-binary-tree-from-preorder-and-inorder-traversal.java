class Solution {
    int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, map, 0, inorder.length - 1);
    }

    TreeNode dfs(int[] preorder, HashMap<Integer, Integer> map, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootval = preorder[idx++];
        int range = map.get(rootval);

        TreeNode root = new TreeNode(rootval);

        root.left = dfs(preorder, map, start, range - 1);
        root.right = dfs(preorder, map, range + 1, end);
        return root;
    }
}
