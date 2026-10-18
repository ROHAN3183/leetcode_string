class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        return bfs(root);
    }

    List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node != null && node.left != null) {
                    queue.add(node.left);
                }
                if (node != null && node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}