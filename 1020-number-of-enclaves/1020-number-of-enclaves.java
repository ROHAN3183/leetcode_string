class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1 && !visited[0][i]) {
                dfs(grid, visited, 0, i);
            }
        }
        for (int i = 0; i < m; i++) {
            if (grid[n - 1][i] == 1 && !visited[n - 1][i]) {
                dfs(grid, visited, n - 1, i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) {
                dfs(grid, visited, i, 0);
            }
        }
        for (int i = 0; i < n; i++) {
            if (grid[i][m - 1] == 1 && !visited[i][m - 1]) {
                dfs(grid, visited, i, m - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(int[][] grid, boolean[][] visited, int i, int j) {

        int n = grid.length;
        int m = grid[0].length;

        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || grid[i][j] == 0) {
            return;
        }

        if (grid[i][j] == 1) {
            visited[i][j] = true;
        }

        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i, j - 1);
        dfs(grid, visited, i, j + 1);

        return;
    }
}