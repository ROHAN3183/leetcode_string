class Solution {
    class Pair {
        int idx;
        TreeNode node;

        Pair(int idx, TreeNode node) {
            this.idx = idx;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int first = 0;
            int last = 0;

            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                if (i == 0) {
                    first = pair.idx;
                }
                if (i == size - 1) {
                    last = pair.idx;
                }
                if (pair.node.left != null) {
                    queue.add(new Pair(2 * pair.idx + 1, pair.node.left));
                }
                if (pair.node.right != null) {
                    queue.add(new Pair(2 * pair.idx + 2, pair.node.right));
                }
            }
            max = Math.max(max, last - first + 1);
        }
        return max;
    }
}