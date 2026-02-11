class Solution {
    HashMap<TreeNode, TreeNode> map;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        map = new HashMap<>();
        dfs(root, null);
        return bfs(root, target, k);
    }

    void dfs(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        map.put(root, parent);
        dfs(root.left, root);
        dfs(root.right, root);
        return;
    }

    List<Integer> bfs(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        queue.add(target);
        visited.add(target);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (level == k) {
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();
                    result.add(node.val);
                }
                return result;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.add(node.right);
                }
                TreeNode parent = map.get(node);

                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.add(parent);

                }
            }
            level++;
        }
        return result;
    }
}