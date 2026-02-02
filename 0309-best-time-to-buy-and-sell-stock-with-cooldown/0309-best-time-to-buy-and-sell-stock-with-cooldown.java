class Solution {
    Integer[][] dp;

    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length + 1][prices.length + 1];
        return dfs(prices, 0, prices.length);
    }

    int dfs(int[] prices, int idx, int prev) {
        if (idx >= prices.length) {
            return 0;
        }
        if (dp[idx][prev]!= null) {
            return dp[idx][prev];
        }
        int ans = 0;
        if (prev == prices.length) {
            int take = 0 + dfs(prices, idx + 1, idx);
            int nottake = 0 + dfs(prices, idx + 1, prev);
            ans = Math.max(take, nottake);
        } else if (prices[idx] > prices[prev]) {
            int take = prices[idx] - prices[prev] + dfs(prices, idx + 2, prices.length);
            int nottake = dfs(prices, idx + 1, prev);
            ans = Math.max(take, nottake);
        }
        return dp[idx][prev] = ans;
    }
}