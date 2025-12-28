class Solution {
    Integer[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new Integer[n][n];
        return dfs(triangle, 0, 0);
    }

    int dfs(List<List<Integer>> triangle, int row, int col) {
        if (row > triangle.size()) {
            return 0;
        }
        if (row == triangle.size() - 1) {
            return dp[row][col] = triangle.get(row).get(col);
        }
        if (dp[row][col] != null) {
            return dp[row][col];
        }

        int step1 = triangle.get(row).get(col) + dfs(triangle, row + 1, col);
        int step2 = triangle.get(row).get(col) + dfs(triangle, row + 1, col + 1);

        return dp[row][col] = Math.min(step1, step2);
    }
}