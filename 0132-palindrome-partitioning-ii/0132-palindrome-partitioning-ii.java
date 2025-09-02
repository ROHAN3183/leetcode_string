class Solution {
    Integer[] dp;

    public int minCut(String s) {
        dp = new Integer[2001];
        return dfs(s, 0) - 1;
    }

    int dfs(String s, int i) {
        if (i >= s.length()) {
            return 0;
        }
        if (dp[i] != null) {
            return dp[i];
        }

        int result = Integer.MAX_VALUE;
        for (int j = i; j < s.length(); j++) {
            if (isValid(s, i, j)) {
                int min = 1 + dfs(s, j + 1);
                result = Math.min(result, min);
            }
        }
        return dp[i] = result;
    }

    boolean isValid(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}