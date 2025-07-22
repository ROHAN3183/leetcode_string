class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return dfs(obstacleGrid, 0, 0, dp);
    }

    int dfs(int[][] grid, int row, int col, int[][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        if (row >= m || col >= n || grid[row][col] == 1) {
            return 0;
        }

        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        dp[row][col] = dfs(grid, row + 1, col, dp) + dfs(grid, row, col + 1, dp);
        return dp[row][col];
    }
}
