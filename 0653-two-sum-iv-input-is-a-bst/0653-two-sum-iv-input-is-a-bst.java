class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) {
                return true;
            } else if (sum > k) {
                j--;
            } else if (sum < k) {
                i++;
            }
        }
        return false;

    }

    void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right,list);
        return;
    }
}