class Solution {
    int MOD = 1_000_000_007;

    public int countGoodStrings(int low, int high, int zero, int one) {
        Integer[] dp = new Integer[high + 1];
        return dfs(0, low, high, zero, one, dp);
    }

     int dfs(int length, int low, int high, int zero, int one, Integer[] dp) {
        if (length > high) {
            return 0;
        }
        if (dp[length] != null) {
            return dp[length];
        }

        int count = 0;
        if (length >= low && length <= high) {
            count = 1;
        }

        int takeZero = dfs(length + zero, low, high, zero, one, dp);
        int takeOne  = dfs(length + one, low, high, zero, one, dp);

        count = (int)(((long)count + takeZero + takeOne) % MOD);

        dp[length] = count;
        return count;
    }
}
