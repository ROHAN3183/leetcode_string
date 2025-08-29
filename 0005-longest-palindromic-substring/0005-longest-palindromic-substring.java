class Solution {
    public String longestPalindrome(String s) {
        Boolean[][] dp = new Boolean[1001][1001];
        int n = s.length();
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < n; j++) {
                boolean valid = solver(s, i, j, dp);
                if (valid && max.length() < j - i + 1) {
                    max = s.substring(i, j + 1);
                }
            }
        }
        return max;
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