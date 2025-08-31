class Solution {
    Integer[][] dp;

    public int minInsertions(String s) {
        dp = new Integer[501][501];
        return dfs(s, 0, s.length() - 1);
    }

    int dfs(String s, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            return dfs(s, i + 1, j - 1);
        }
        int left = 1 + dfs(s, i, j - 1);
        int right = 1 + dfs(s, i + 1, j);
        return dp[i][j] = Math.min(left, right);
    }
}