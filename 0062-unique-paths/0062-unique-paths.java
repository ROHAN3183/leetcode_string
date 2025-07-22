class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        // Initialize dp array with -1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        
        return countPaths(m - 1, n - 1, dp);
    }
    
    private int countPaths(int i, int j, int[][] dp) {
        // Base case: if we're at the starting cell
        if (i == 0 && j == 0) return 1;

        // If out of bounds
        if (i < 0 || j < 0) return 0;

        // If already computed
        if (dp[i][j] != -1) return dp[i][j];

        // Compute from top and left
        int up = countPaths(i - 1, j, dp);
        int left = countPaths(i, j - 1, dp);

        dp[i][j] = up + left;
        return dp[i][j];
    }
}
