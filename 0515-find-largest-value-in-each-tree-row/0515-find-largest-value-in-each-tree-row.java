class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }

        return list;

    }

    void dfs(TreeNode root, int level, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        if (map.containsKey(level)) {
            if (map.get(level) < root.val) {
                map.put(level, root.val);
            }
        } else {
            map.put(level, root.val);
        }
        dfs(root.left, level + 1, map);
        dfs(root.right, level + 1, map);
    }
}