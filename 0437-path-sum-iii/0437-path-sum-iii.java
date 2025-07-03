class Solution {
    int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L, 1);
        dfs(root, prefixSum, targetSum, 0);
        return ans;
    }

    void dfs(TreeNode root, HashMap<Long, Integer> prefixSum, int targetSum, long sum) {
        if (root == null) {
            return;
        }
        sum = sum + root.val;

        if (prefixSum.containsKey(sum - targetSum)) {
            ans = ans + prefixSum.get(sum - targetSum);

        }

        prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);

        dfs(root.left, prefixSum, targetSum, sum);
        dfs(root.right, prefixSum, targetSum, sum);

        prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) - 1);
    }
}