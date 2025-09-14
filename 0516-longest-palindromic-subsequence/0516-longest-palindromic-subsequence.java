class Solution {
    Integer[][] memo;

    public int longestPalindromeSubseq(String s) {
        memo = new Integer[1001][1001];
        return dfs(s, 0, s.length() - 1);
    }

    int dfs(String s, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            return 2 + dfs(s, i + 1, j - 1);
        } else {
            memo[i][j] = Math.max(dfs(s, i + 1, j), dfs(s, i, j - 1));
        }
        return memo[i][j];

    }
}