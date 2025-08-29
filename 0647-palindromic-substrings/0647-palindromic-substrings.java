class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[1001][1001];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (solver(s, i, j, dp)) {
                    count++;
                }
            }
        }
        return count;
    }

    boolean solver(String s, int i, int j, Boolean[][] dp) {
        if (i >= j) {
            return true;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = solver(s, i + 1, j - 1, dp);
        }
        return dp[i][j] = false;
    }
}