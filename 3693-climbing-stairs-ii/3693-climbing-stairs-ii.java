class Solution {
    Integer[] dp;

    public int climbStairs(int n, int[] costs) {
        dp = new Integer[n + 1];
        return dfs(costs, n, 0);
    }

    int dfs(int[] costs, int n, int idx) {
        if (idx == n) {
            return 0;
        }
        if (dp[idx] != null) {
            return dp[idx];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 3; i++) {

            int step = idx + i;

            if (step <= n) {
                int cost = dfs(costs,n, step);
                if (cost != Integer.MAX_VALUE) {
                    min = Math.min(min, (cost + costs[step - 1] + i * i));
                }
            }
        }
        return dp[idx] = min;
    }
}