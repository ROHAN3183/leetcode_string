class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        Boolean[][] dp = new Boolean[n][n];
        for (int L = 1; L <= n; L++) {
            for (int i = 0; L + i - 1 < n; i++) {
                int j = L + i - 1;
                if (i == j) {
                    dp[i][j] = true;
                } else if (j == i + 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);

                }
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}