class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return DP(n, dp);

    }

    int DP(int n, int[] dp) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = DP(n - 1, dp) + DP(n - 2, dp);
        
        return dp[n];
    }
}