class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>();
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int rightVal = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                rightVal = node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(rightVal);
        }
        return result;
    }

}