class Solution {
    public int findBottomLeftValue(TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeNode> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
               
                TreeNode node = queue.poll();
                level.add(node);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(level);
        }
        return result.get(result.size()-1).get(0).val;

    }
}