class Solution {
    Integer[][] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new Integer[amount + 1][coins.length];
        int result = dfs(coins, amount, 0);
        if (result == Integer.MAX_VALUE / 2) {
            return -1;
        }
        return result;
    }

    int dfs(int[] coins, int amount, int idx) {
        if (amount == 0) {
            return 0;
        }
        if (idx >= coins.length) {
            return Integer.MAX_VALUE / 2;
        }
        if (dp[amount][idx] != null) {
            return dp[amount][idx];
        }
        if (coins[idx] > amount) {
            return dp[amount][idx] = 0 + dfs(coins, amount, idx + 1);
        }
        int take = 1 + dfs(coins, amount - coins[idx], idx);
        int nottake = 0 + dfs(coins, amount, idx + 1);

        return dp[amount][idx] = Math.min(take, nottake);
    }
}