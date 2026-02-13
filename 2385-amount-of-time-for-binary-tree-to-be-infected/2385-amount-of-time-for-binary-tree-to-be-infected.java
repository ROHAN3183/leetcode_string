class Solution {
    class info {
        int depth;
        TreeNode node;

        info(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    HashMap<TreeNode, TreeNode> map = new HashMap<>();

    public int amountOfTime(TreeNode root, int start) {
        TreeNode target = dfs(root, start);
        dfsParent(root, null);
        return bfs(target);

    }

    TreeNode dfs(TreeNode root, int start) {
        if (root == null) {
            return null;

        }
        if (root.val == start) {
            return root;
        }
        TreeNode left = dfs(root.left, start);
        TreeNode right = dfs(root.right, start);

        if (left == null && right == null) {
            return null;
        } else if (left != null) {
            return left;
        } else {
            return right;
        }
    }

    void dfsParent(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (parent != null) {
            map.put(root, parent);
        }

        dfsParent(root.left, root);
        dfsParent(root.right, root);
        return;
    }

    int bfs(TreeNode root) {
        Queue<info> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(new info(root, 0));
        visited.add(root);
        int maxTime = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                info pair = queue.poll();
                int newDepth = pair.depth;
                maxTime = Math.max(maxTime, pair.depth);

                if (pair.node.left != null && !visited.contains(pair.node.left)) {
                    queue.add(new info(pair.node.left, newDepth + 1));
                    visited.add(pair.node.left);
                }
                if (pair.node.right != null && !visited.contains(pair.node.right)) {
                    queue.add(new info(pair.node.right, newDepth + 1));
                    visited.add(pair.node.right);
                }
                TreeNode parent = map.get(pair.node);
                if (parent != null && !visited.contains(parent)) {
                    queue.add(new info(parent, newDepth + 1));
                    visited.add(parent);
                }
            }
        }
        return maxTime;
    }

}