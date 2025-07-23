class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Integer[][][] dp = new Integer[n][m][m];
        return dfs(grid, 0, 0, grid[0].length - 1, dp);

    }

    int dfs(int[][] grid, int row, int col1, int col2, Integer[][][] dp) {
        if (col1 >= grid[0].length || col1 < 0 || col2 >= grid[0].length || col2 < 0) {
            return 0;
        }
        if (dp[row][col1][col2] != null) {
            return dp[row][col1][col2];
        }
        int result = grid[row][col1];
        if (col1 != col2) {
            result += grid[row][col2];
        }
        if (row + 1 < grid.length) {
            int max = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    max = Math.max(max, dfs(grid, row + 1, col1 + i, col2 + j, dp));
                }
            }
            result += max;
        }
        dp[row][col1][col2] = result;
        return result;

    }
}