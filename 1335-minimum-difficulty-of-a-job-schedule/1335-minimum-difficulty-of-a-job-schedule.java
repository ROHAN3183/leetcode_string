class Solution {
    Integer[][] dp;

    public int minDifficulty(int[] jobDifficulty, int d) {
        dp = new Integer[1001][301];
        if (jobDifficulty.length < d) {
            return -1;
        }
        return dfs(jobDifficulty, d, 0);
    }

    int dfs(int[] jobDifficulty, int d, int idx) {
        if (d == 1) {
            int max = 0;
            for (int i = idx; i < jobDifficulty.length; i++) {
                max = Math.max(jobDifficulty[i], max);
            }
            return max;
        }
        if (dp[d][idx] != null) {
            return dp[d][idx];
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = idx; i <= jobDifficulty.length - d; i++) {
            max = Math.max(max, jobDifficulty[i]);
            int result = max + dfs(jobDifficulty, d - 1, i + 1);
            min = Math.min(result, min);

        }
        return dp[d][idx] = min;
    }
}