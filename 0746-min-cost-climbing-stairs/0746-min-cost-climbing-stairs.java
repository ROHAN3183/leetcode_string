class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[1001];
        Arrays.fill(dp, -1);
        return Math.min(dfs(cost, 0, dp), dfs(cost, 1, dp));
    }

    int dfs(int[] cost, int idx, int[] dp) {
        if (idx >= cost.length) {
            return 0;

        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int oneStep = cost[idx] + dfs(cost, idx + 1, dp);

        int twoSteps = cost[idx] + dfs(cost, idx + 2, dp);

        return dp[idx] = Math.min(oneStep, twoSteps);

    }
}