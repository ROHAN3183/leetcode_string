class Solution {
    int ans;

    public int minIncrements(int n, int[] cost) {
        ans = 0;
        dfs(cost, 1, n);
        return ans;
    }

    int dfs(int[] cost, int idx, int n) {
        if (idx > n) {
            return 0;
        }
        int left = dfs(cost, 2 * idx, n);
        int right = dfs(cost, 2 * idx + 1, n);

        ans += Math.abs(left - right);
        int maxSum = Math.max(left, right);
        
        return maxSum + cost[idx - 1];
    }
}