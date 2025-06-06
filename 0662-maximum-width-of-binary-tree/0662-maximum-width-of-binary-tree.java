class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> node = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        int maxWidth = 0;

        node.add(root);
        index.add(1);

        while (!node.isEmpty()) {
            int size = node.size();
            int first = index.peek();
            int last = first;

            for (int i = 0; i < size; i++) {
                TreeNode current = node.poll();
                int right = index.poll();
                last = right;

                if (current.left != null) {
                    node.add(current.left);
                    index.add(2 * right);
                }

                if (current.right != null) {
                    node.add(current.right);
                    index.add(2 * right + 1);
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}
