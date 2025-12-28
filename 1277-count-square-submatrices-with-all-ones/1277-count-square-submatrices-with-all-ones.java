class Solution {
    Integer[][] dp;

    public int countSquares(int[][] matrix) {
        dp = new Integer[matrix.length][matrix[0].length];
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result += dfs(matrix, i, j);
            }
        }
        return result;
    }

    int dfs(int[][] matrix, int i, int j) {
        if (i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }
        if (matrix[i][j] == 0) {
            return dp[i][j] = 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int right = dfs(matrix, i, j + 1);
        int bottom = dfs(matrix, i + 1, j);
        int diagonal = dfs(matrix, i + 1, j + 1);

        return dp[i][j] = 1 + Math.min(right, Math.min(bottom, diagonal));
    }
}