class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, targetSum, list);
        return result;

    }

    void dfs(TreeNode root, int targetSum, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {

            if (targetSum - root.val == 0) {
                list.add(root.val);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }

        list.add(root.val);
        dfs(root.left, targetSum - root.val, list);
        list.remove(list.size() - 1);
        list.add(root.val);
        dfs(root.right, targetSum - root.val, list);
        list.remove(list.size() - 1);

        return;
    }
}