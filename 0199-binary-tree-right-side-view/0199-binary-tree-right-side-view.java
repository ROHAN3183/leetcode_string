class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        return bfs(root);
    }

    List<Integer> bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode ans = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);

                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                ans = node;
            }
            result.add(ans.val);

        }
        return result;
    }
}