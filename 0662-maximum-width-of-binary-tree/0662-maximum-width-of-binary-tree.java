class Solution {
    class info {
        TreeNode node;
        int idx;

        info(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        return bfs(root);
    }

    int bfs(TreeNode root) {
        int max = 0;
        Queue<info> queue = new LinkedList<>();
        queue.add(new info(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int low = 0;
            int high = 0;
            for (int i = 0; i < size; i++) {
                info value = queue.poll();
                if (i == 0) {
                    low = value.idx;
                }
                if (i == size - 1) {
                    high = value.idx;
                }
                if (value.node.left != null) {
                    queue.add(new info(value.node.left, 2 * value.idx + 1));
                }
                if (value.node.right != null) {
                    queue.add(new info(value.node.right, 2 * value.idx + 2));
                }
            }
            max = Math.max(max, high - low + 1);
        }
        return max;
    }
}