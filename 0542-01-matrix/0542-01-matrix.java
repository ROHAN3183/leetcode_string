class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] result = new int[n][m];
        int[][] dp = new int[n][m];
        
        // Initialize dp matrix with -1 to indicate uncomputed cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        // Iterate through each cell and perform DFS for '1's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    // Create a new visited array for each starting DFS call
                    boolean[][] visited = new boolean[n][m];
                    result[i][j] = dfs(mat, i, j, visited, n, m, dp);
                } else {
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }

    int dfs(int[][] mat, int i, int j, boolean[][] visited, int n, int m, int[][] dp) {
        // Base case: out of bounds
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return Integer.MAX_VALUE;
        }
        
        // Base case: found a '0'
        if (mat[i][j] == 0) {
            return 0;
        }
        
        // Memoization check
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Avoid infinite recursion by checking the visited array for the *current* path
        if (visited[i][j]) {
            return Integer.MAX_VALUE;
        }

        visited[i][j] = true;

        // Recursive calls to all four neighbors
        int left = dfs(mat, i, j - 1, visited, n, m, dp);
        int right = dfs(mat, i, j + 1, visited, n, m, dp);
        int top = dfs(mat, i - 1, j, visited, n, m, dp);
        int bottom = dfs(mat, i + 1, j, visited, n, m, dp);
        
        visited[i][j] = false; // Backtrack

        int minDist = Math.min(Math.min(left, right), Math.min(top, bottom));

        // Store result in memoization table
        if (minDist == Integer.MAX_VALUE) {
            dp[i][j] = Integer.MAX_VALUE;
        } else {
            dp[i][j] = 1 + minDist;
        }
        return dp[i][j];
    }
}
