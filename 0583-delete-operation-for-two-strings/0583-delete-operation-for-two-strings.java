class Solution {
    Integer [][] dp;
    public int minDistance(String word1, String word2) {
        dp =new Integer[word1.length()][word2.length()];
        return dfs(word1, word2, 0, 0);
    }

    int dfs(String word1, String word2, int i, int j) {
        if (i >= word1.length()) {
            return word2.length() - j;
        }

        if (j >= word2.length()) {
            return word1.length() - i;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int left = 0;
        int right = 0;
        int valid = 0;

        if (word1.charAt(i) != word2.charAt(j)) {
            left = 1 + dfs(word1, word2, i + 1, j);
            right = 1 + dfs(word1, word2, i, j + 1);
        } else {
            valid = dfs(word1, word2, i + 1, j + 1);
        }

        return dp[i][j]=valid + Math.min(left, right);
    }
}