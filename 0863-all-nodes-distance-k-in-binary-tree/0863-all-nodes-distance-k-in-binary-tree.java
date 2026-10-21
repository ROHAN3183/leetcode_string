class Solution {
    HashMap<Integer, List<Integer>> map;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) {
            return new ArrayList<>();
        }
        map = new HashMap<>();
        dfs(root, -1);
        if (target != null) {
            return bfs(target.val, k);
        }
        return new ArrayList<>();
    }

    void dfs(TreeNode root, int parent) {
        if (root == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        if (parent != -1) {
            list.add(parent);
        }
        if (root.left != null) {
            list.add(root.left.val);
        }
        if (root.right != null) {
            list.add(root.right.val);
        }
        map.put(root.val, list);
        dfs(root.left, root.val);
        dfs(root.right, root.val);
        return;
    }

    List<Integer> bfs(int source, int k) {
        HashMap<Integer, Boolean> visited = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(source);
        visited.put(source, true);

        for (int level = 0; level < k; level++) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int value = queue.poll();
                List<Integer> list = map.get(value);

                for (int j = 0; j < list.size(); j++) {
                    if (!visited.containsKey(list.get(j))) {
                        queue.add(list.get(j));
                        visited.put(list.get(j), true);
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }
}