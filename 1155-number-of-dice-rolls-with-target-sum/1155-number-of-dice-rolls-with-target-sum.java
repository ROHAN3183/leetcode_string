class Solution {
    static final int mod = 1000_000_007;
    Integer[][] dp;
    public int numRollsToTarget(int n, int k, int target) {
        dp = new Integer[target + 1][n + 1];
        return dfs(n, k, target, 0);
    }

    int dfs(int n, int k, int target, int size) {
        if (size == n) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        if (dp[target][size] != null) {
            return dp[target][size];
        }
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            if (i <= target) {
                ans = (ans + dfs(n, k, target - i, size + 1)) % mod;
            }
        }
        return dp[target][size] = ans;
    }
}