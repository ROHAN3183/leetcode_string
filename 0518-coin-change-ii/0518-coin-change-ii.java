class Solution {
    Integer[][] dp;

    public int change(int amount, int[] coins) {
        dp = new Integer[5001][301];
        return dfs(coins, amount, 0);
    }

    int dfs(int[] coins, int amount, int idx) {
        if (amount == 0) {
            return 1;
        }
        if (idx >= coins.length) {
            return 0;
        }
        if (dp[amount][idx] != null) {
            return dp[amount][idx];
        }
        if (coins[idx] > amount) {
            return dfs(coins, amount, idx + 1);
        }
        int take = dfs(coins, amount - coins[idx], idx);
        int nottake = dfs(coins, amount, idx + 1);
        return dp[amount][idx] = take + nottake;
    }
}