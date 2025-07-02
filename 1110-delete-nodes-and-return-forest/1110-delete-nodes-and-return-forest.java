class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int val : to_delete) {
            set.add(val);
        }
        if (!set.contains(root.val)) {
            result.add(root);
        }

        dfs(root, to_delete, result, set);
        return result;

    }

    TreeNode dfs(TreeNode root, int[] to_delete, List<TreeNode> result, Set<Integer> set) {
        if (root == null) {
            return null;
        }
        root.left = dfs(root.left, to_delete, result, set);
        root.right = dfs(root.right, to_delete, result, set);
        if (set.contains(root.val)) {
            if (root.left != null) {
                result.add(root.left);
            }
            if (root.right != null) {
                result.add(root.right);
            }
            return null;
        }

        return root;
    }
}