class Solution {
    Integer[][] dp;

    public int maxProfit(int[] prices, int fee) {
        dp = new Integer[prices.length][2];
        return dfs(prices, fee, 0, 0);
    }

    int dfs(int[] prices, int fee, int idx, int holding) {
        if (idx >= prices.length) {
            return 0;
        }

        if (dp[idx][holding] != null) {
            return dp[idx][holding];
        }
        int ans;

        if (holding == 0) {
            int take = -prices[idx] + dfs(prices, fee, idx + 1, 1);
            int nottake = dfs(prices, fee, idx + 1, holding);
            ans = Math.max(take, nottake);
        } else {
            int sell = (prices[idx] - fee) + dfs(prices, fee, idx + 1, 0);
            int notsell = dfs(prices, fee, idx + 1, holding);
            ans = Math.max(sell, notsell);
        }
        return dp[idx][holding] = ans;
    }
}