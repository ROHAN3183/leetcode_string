class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> level = new ArrayList<>();
        bfsSum(root, level);
        bfs(root,level);
        return root;

    }

    void bfsSum(TreeNode root, List<Integer> level) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum = sum + node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level.add(sum);

        }

    }

    void bfs(TreeNode root, List<Integer> level) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            root.val = 0;
        }
        if (queue != null) {
            queue.offer(root);
        }
        int idx=1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node=queue.poll();
                int left=0;
                int right=0;
                if(node.left!=null){
                    left=node.left.val; 
                }
                if(node.right!=null){
                    right=node.right.val;
                }
                int SiblingSum=left+right;

                if (node.left != null) {
                    node.left.val=level.get(idx)-SiblingSum;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val=level.get(idx)-SiblingSum;
                    queue.offer(node.right);
                }
            }
            idx++;
        }

    }
}